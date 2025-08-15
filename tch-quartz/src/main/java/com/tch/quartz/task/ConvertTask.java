package com.tch.quartz.task;

import com.tch.common.enums.DocumentsBase;
import com.tch.common.enums.TypeConversion;
import com.tch.common.utils.StringUtils;
import com.tch.common.utils.uuid.IdUtils;
import com.tch.system.constants.Constants;
import com.tch.system.domain.DnTaskBasic;
import com.tch.system.domain.TBusisysinfo;
import com.tch.system.domain.YthTGaShlbjxxInfo;
import com.tch.system.entity.common.*;
import com.tch.system.entity.convert2xml.ConvertEntity;
import com.tch.system.entity.convert2xml.ConvertEntityApasInfo;
import com.tch.system.entity.finish2xml.*;
import com.tch.system.entity.finish2xml.FinishApasInfo;
import com.tch.system.entity.finish2xml.FinishBody;
import com.tch.system.entity.next2xml.NextCaseEntity;
import com.tch.system.entity.next2xml.NextNode;
import com.tch.system.entity.nextxml.NextBean;
import com.tch.system.entity.wsspxml.OriginCaseEntity;
import com.tch.system.entity.xml2bean.*;
import com.tch.system.mapper.DnTaskBasicMapper;
import com.tch.system.mapper.FinishXmlMapper;
import com.tch.system.mapper.WsspXmlMapper;
import com.tch.system.mapper.YthTGaShlbjxxInfoMapper;
import com.tch.system.service.ITBusisysinfoService;
import com.tch.system.util.CaseXmlConverter;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.tch.system.util.CaseXmlConverter.parseXml;

/**
 * @author ：Wythe
 * @description： 数据转换定时任务类
 * @date ：2024/03/20 14:27
 */
@Component("convertTask")
public class ConvertTask {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private YthTGaShlbjxxInfoMapper ythTGaShlbjxxInfoMapper;
    @Resource
    private ITBusisysinfoService itBusisysinfoService;

    private String prevLinkUuid = null;//上一环节uuid

    @Resource
    private DnTaskBasicMapper basicMapper;

    @Resource
    private WsspXmlMapper wsspXmlMapper;

    @Resource
    private FinishXmlMapper finishXmlMapper;


    public static ConvertTask convertTask;

    @PostConstruct
    public void init() {
        convertTask = this;
        convertTask.wsspXmlMapper = this.wsspXmlMapper;
        convertTask.finishXmlMapper = this.finishXmlMapper;
    }


    //第二次进行转换
    public void againConvert(String id) {
        List<YthTGaShlbjxxInfo> businessBeanList = ythTGaShlbjxxInfoMapper.selectYthTGaShlbjxxVersion(id);
        if (businessBeanList.size() > 0) {
            for (YthTGaShlbjxxInfo businessBean : businessBeanList) {
                //生成补发件id
                prevLinkUuid = Constants.RP + CaseXmlConverter.getUuid();
                reissueCreateXmlData(businessBean);
                businessBean.setUpdatedTime(new Date());//注入更新时间
                businessBean.setVersion(Long.valueOf(Constants.VERSION_DEFAULT_TYPE_2));//第二次  版本号修改为2
                ythTGaShlbjxxInfoMapper.updateYthTGaShlbjxxInfo(businessBean);
            }
        } else {
            System.out.println("没查询到数据");
        }

    }


    //第一次转换
    public void firstConvert(String id) {
        try {
            //先查一条做测试，后续改成批量处理
            List<YthTGaShlbjxxInfo> businessBeanList = ythTGaShlbjxxInfoMapper.selectYthTGaShlbjxxStartTimeToEndTime(id);
            if (businessBeanList.size() > 0) {
                for (YthTGaShlbjxxInfo businessBean : businessBeanList) {
                    //上一环节id
                    prevLinkUuid = CaseXmlConverter.getUuid();
                    createXmlData(businessBean);
                    businessBean.setUpdatedTime(new Date());//注入更新时间
                    ythTGaShlbjxxInfoMapper.updateYthTGaShlbjxxInfo(businessBean);
                }
            } else {
                System.out.println("没查询到数据");
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }
    }


    //第一次创建xml数据
    private void createXmlData(YthTGaShlbjxxInfo businessBean) {
        //初始办件信息
        OriginCaseEntity convertEntity = (OriginCaseEntity) CaseXmlConverter.parseXml(businessBean.getWsspXml(), new OriginCaseEntity());
        //查询出对应的事项编码
        DnTaskBasic dnTaskBasic = basicMapper.selectDnTaskBasicByCode(convertEntity.getBody().getApasInfo().getServiceCode());
        //没有跳过
        if (ObjectUtils.isNotEmpty(dnTaskBasic) && StringUtils.isEmpty(businessBean.getSuspendXml()) && StringUtils.isEmpty(businessBean.getResumeXml())) {
            String wsspData = postWsspInfo(convertEntity, dnTaskBasic);
            ConvertEntity wsspInfo = (ConvertEntity) parseXml(wsspData, new ConvertEntity());
            //过程信息
            String nextData = postNextInfo(businessBean, wsspInfo);
            NextCaseEntity nextInfo = (NextCaseEntity) parseXml(nextData, new NextCaseEntity());
            //上报审批结果信息
            postFinishInfo(businessBean, wsspInfo, nextInfo);
        } else {
            System.out.println("该办件找不到事项编码: " + businessBean.getProvincePullDataAuditId());
        }
    }

    //创建补发xml数据
    private void reissueCreateXmlData(YthTGaShlbjxxInfo businessBean) {
        //初始办件信息
        OriginCaseEntity convertEntity = (OriginCaseEntity) CaseXmlConverter.parseXml(businessBean.getWsspXml(), new OriginCaseEntity());
        //查询出对应的事项编码
        DnTaskBasic dnTaskBasic = basicMapper.selectDnTaskBasicByCode(convertEntity.getBody().getApasInfo().getServiceCode());
        //没有跳过
        if (ObjectUtils.isNotEmpty(dnTaskBasic) && StringUtils.isEmpty(businessBean.getSuspendXml()) && StringUtils.isEmpty(businessBean.getResumeXml())) {
            String wsspData = postWsspInfo(convertEntity, dnTaskBasic);
            ConvertEntity wsspInfo = (ConvertEntity) parseXml(wsspData, new ConvertEntity());
            //过程信息
            String nextData = reissuePostNextInfo(businessBean, wsspInfo);
            NextCaseEntity nextInfo = (NextCaseEntity) parseXml(nextData, new NextCaseEntity());
            //上报审批结果信息
            reissuePostFinishInfo(businessBean, wsspInfo, nextInfo);
        } else {
            System.out.println("该办件找不到事项编码: " + businessBean.getProvincePullDataAuditId());
        }
    }


    public String postWsspInfo(OriginCaseEntity convertEntity, DnTaskBasic dnTaskBasic) {
        TBusisysinfo busisysinfo = setTBusisysinfoFromarea();
        busisysinfo.setUnid(prevLinkUuid);
        //把xml内容转为实体
        String wsspData = ConvertWsspTask.createWsspData(convertEntity, prevLinkUuid, logger, dnTaskBasic);
        busisysinfo.setTchar1(busisysinfo.getUnid());
        busisysinfo.setApplyfrom(DocumentsBase.checkKeyExists(convertEntity.getApplyFrom()));//来源系统代码
        busisysinfo.setType(TypeConversion.checkKeyExists(convertEntity.getType()));//办件信息
        busisysinfo.setContent(wsspData.getBytes(StandardCharsets.UTF_8));
        busisysinfo.setCopyright(convertEntity.getXsd());
        busisysinfo.setBusino(convertEntity.getBody().getApasInfo().getSn());
        itBusisysinfoService.insertTBusisysinfo(busisysinfo);
        return wsspData;

    }


    //生成第一次发送过程信息
    public String postNextInfo(YthTGaShlbjxxInfo businessBean, ConvertEntity wsspInfo) {
        String[] xmlDocuments = businessBean.getNextXml().split("(?=<\\?xml)");
        String nextData = null;
        for (String xmlDocument : xmlDocuments) {
            String nextUuid = CaseXmlConverter.getUuid();
            nextData = getNextData(businessBean, wsspInfo, xmlDocument, nextUuid);
        }

        return nextData;
    }

    //生成补发过程信息
    public String reissuePostNextInfo(YthTGaShlbjxxInfo businessBean, ConvertEntity wsspInfo) {
        String[] xmlDocuments = businessBean.getNextXml().split("(?=<\\?xml)");
        String nextData = null;
        for (String xmlDocument : xmlDocuments) {
            String nextUuid = Constants.RP + CaseXmlConverter.getUuid();
            nextData = getNextData(businessBean, wsspInfo, xmlDocument, nextUuid);
        }

        return nextData;
    }

    private String getNextData(YthTGaShlbjxxInfo businessBean, ConvertEntity wsspInfo, String xmlDocument, String nextUuid) {
        String nextData;
        NextBean nextBean = (NextBean) CaseXmlConverter.parseXml(xmlDocument, new NextBean());
        nextData = ConvertNextTask.createNextData(nextBean, wsspInfo, businessBean, nextUuid, prevLinkUuid, logger);
        TBusisysinfo busisysinfo = setTBusisysinfoFromarea();
        prevLinkUuid = nextUuid;//更新uuid
        busisysinfo.setUnid(nextUuid);
        busisysinfo.setTchar1(busisysinfo.getUnid());
        busisysinfo.setApplyfrom(DocumentsBase.checkKeyExists(nextBean.getApplyFrom()));//来源
        busisysinfo.setType(TypeConversion.checkKeyExists(nextBean.getType()));//办件信息
        busisysinfo.setContent(nextData.getBytes(StandardCharsets.UTF_8));
        busisysinfo.setCopyright(nextBean.getXsd());
        busisysinfo.setBusino(nextBean.getNextBody().getNextApasInfo().getSN());
        itBusisysinfoService.insertTBusisysinfo(busisysinfo);
        return nextData;
    }


    public void postFinishInfo(YthTGaShlbjxxInfo businessBean, ConvertEntity wsspInfo, NextCaseEntity nextInfo) {
        String finishUuid = CaseXmlConverter.getUuid();
        getFinishInfo(businessBean, wsspInfo, nextInfo, finishUuid);
    }

    public void reissuePostFinishInfo(YthTGaShlbjxxInfo businessBean, ConvertEntity wsspInfo, NextCaseEntity nextInfo) {
        String finishUuid = Constants.RP + CaseXmlConverter.getUuid();
        getFinishInfo(businessBean, wsspInfo, nextInfo, finishUuid);
    }

    private void getFinishInfo(YthTGaShlbjxxInfo businessBean, ConvertEntity wsspInfo, NextCaseEntity nextInfo, String finishUuid) {
        FinishBean finishCaseEntity = (FinishBean) CaseXmlConverter.parseXml(businessBean.getFinishXml(), new FinishBean());
        String resultData = createResultData(finishCaseEntity, wsspInfo, nextInfo, finishUuid, prevLinkUuid, logger);
        TBusisysinfo busisysinfo = setTBusisysinfoFromarea();
        busisysinfo.setUnid(finishUuid);
        busisysinfo.setTchar1(busisysinfo.getUnid());
        busisysinfo.setApplyfrom(DocumentsBase.checkKeyExists(finishCaseEntity.getApplyFrom()));//来源系统代码
        busisysinfo.setType(TypeConversion.checkKeyExists(finishCaseEntity.getType()));//办件信息
        busisysinfo.setContent(resultData.getBytes(StandardCharsets.UTF_8));
        busisysinfo.setCopyright(finishCaseEntity.getXsd());
        busisysinfo.setBusino(finishCaseEntity.getBody().getApasInfo().getSn());
        itBusisysinfoService.insertTBusisysinfo(busisysinfo);
    }

    //注入来源信息
    private TBusisysinfo setTBusisysinfoFromarea() {
        TBusisysinfo busisysinfo = new TBusisysinfo();
        busisysinfo.setFromareacode(Constants.FromAreaCode);
        busisysinfo.setFromareaname(Constants.FromAreaName);//来源系统名称
        busisysinfo.setToareacode(Constants.ToAreaCode);//目标系统代码
        busisysinfo.setToareaname(Constants.ToAreaName);//目标系统名称
        busisysinfo.setCreatetime(new Timestamp(new Date().getTime()));
        busisysinfo.setXsdtype(Constants.XSD_DEFAULT_TYPE_1);//xsd类型  默认填1
        busisysinfo.setAction(Constants.OPERATION_TYPE_INSERT);//操作状态 新增 "I"
        busisysinfo.setSyncstate(Constants.SYNCSTATE);//同步状态
        busisysinfo.setCreatetime(new Date());
        return busisysinfo;
    }


    /**
     * 生成审批结果xml信息
     */
    public static String createResultData(FinishBean finishCaseEntity, ConvertEntity wsspInfo, NextCaseEntity nextInfo, String finishUuid, String preUnid, Logger logger) {
        // 创建 ConvertEntity 对象及其子对象，并设置属性
        ResultCaseEntity convertEntity = new ResultCaseEntity();
        convertEntity.setApplyFrom(DocumentsBase.checkKeyExists(finishCaseEntity.getApplyFrom()));//窗口申请
        convertEntity.setType(TypeConversion.checkKeyExists(finishCaseEntity.getType()));//审批结果信息
        convertEntity.setUnid(finishUuid);
        convertEntity.setXsd(finishCaseEntity.getXsd());
        //生成路由信息
        Router router = new Router();
        router.setFromAreaCode(Constants.FromAreaCode);
        router.setFromAreaName(Constants.FromAreaName);
        router.setToAreaCode(Constants.ToAreaCode);
        router.setToAreaName(Constants.ToAreaName);
        router.setTargetSystem(Constants.TargetSystem);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        router.setSendTime(date);
        router.setPrevLinkUNID(preUnid);//上一环节UNID
        convertEntity.setRouter(router);
        //生成数据区信息
        FinishBody body = new FinishBody();

        //生成办件信息
        FinishApasInfo apasInfo = new FinishApasInfo();
        ConvertEntityApasInfo wsspInfoConvertApasInfo = wsspInfo.getBody().getApasInfo();
        NextNode nextNode = nextInfo.getBody().getNode();
        //判断是否投资项目
        if (finishCaseEntity.getBody().getFormInfos() != null
                && finishCaseEntity.getBody().getFormInfos().getFormInfos() != null) {//说明是投资监管项目

            CovertFormInfo[] covertFormInfos = finishCaseEntity.getBody().getFormInfos().getFormInfos();
            for (CovertFormInfo covertFormInfo : covertFormInfos) {
                //设置表单信息id  资监管项目时有此部分信息
                String specialLenId = IdUtils.getSpecialLenId(20);
                covertFormInfo.setFormInfoId(specialLenId);
                //关联对应的办件信息
                covertFormInfo.setBusISysInfoUuid(finishUuid);
                //获取扩展信息
                CovertItem[] covertItems = covertFormInfo.getItems();
              convertTask.wsspXmlMapper.insertFormInfo(covertFormInfo);
                for (CovertItem covertItem : covertItems) {
                    //扩展信息和资监管项目信息进行关联
                    covertItem.setDataId(specialLenId);
                  convertTask.wsspXmlMapper.insertItem(covertItem);
                }

            }

            //是否存在照面信息
        } else {
            apasInfo.setApplyType(wsspInfo.getBody().getProposer().getApplyType());//申报种类
            apasInfo.setFromCode(Constants.FromAreaCode);//申报原系统代码

            apasInfo.setSrcMatterID(wsspInfoConvertApasInfo.getSrcMatterID());//原系统的审批事项编号
            apasInfo.setAreaCode(wsspInfoConvertApasInfo.getAreaCode());//审批事项所属区划代码
            apasInfo.setReceiveDeptName(wsspInfoConvertApasInfo.getReceiveDeptName());//实施部门
            apasInfo.setReceiveDeptCode(wsspInfoConvertApasInfo.getReceiveDeptCode());//实施部门统一社会信用代码
            apasInfo.setDeptCode(wsspInfoConvertApasInfo.getReceiveDeptCode());//办结机关统一社会信用代码
            apasInfo.setDeptName(wsspInfoConvertApasInfo.getReceiveDeptName());//办结机关名称

            apasInfo.setSwbMatterID(wsspInfoConvertApasInfo.getSwbMatterID());//省网办的审批事项编号
            apasInfo.setSwbMatterName(wsspInfoConvertApasInfo.getSwbMatterName());//省网办的审批事项名称
            apasInfo.setProjectName(wsspInfoConvertApasInfo.getProjectName());//申报名称（项目名称）
            apasInfo.setSwbSN(wsspInfoConvertApasInfo.getSwbSN());//省网办的申报号
            apasInfo.setSrcSN(wsspInfoConvertApasInfo.getSrcSN());//原系统的申报号
            apasInfo.setVersion(1);//数据版本号
            apasInfo.setProcessedUser(nextNode.getProcessedUser());//办理人
            apasInfo.setProcessedTime(nextNode.getProcessedTime());//办理时间
            apasInfo.setResult(finishCaseEntity.getBody().getApasInfo().getResult());//办理结果
            apasInfo.setDeliveryResult(finishCaseEntity.getBody().getApasInfo().getDeliveryResult());//快递送达结果
            apasInfo.setProcessedOpinion(nextNode.getProcessedOpinion());//办理意见
            apasInfo.setOpenWay(finishCaseEntity.getBody().getApasInfo().getOpenWay());//公开方式
            apasInfo.setIsOpen(finishCaseEntity.getBody().getApasInfo().getMakePublic());//是否主动公开
            apasInfo.setTysjm(wsspInfoConvertApasInfo.getTysjm());
            if (StringUtils.isNotEmpty(finishCaseEntity.getBody().getApasInfo().getIsExistLicence())) {
                apasInfo.setIsExistLicence(finishCaseEntity.getBody().getApasInfo().getIsExistLicence());
            } else {
                apasInfo.setIsExistLicence("0");//是否存在照面信息
            }

            apasInfo.setResultType(1);//办结类型 默认为1
            apasInfo.setResultDesc(nextNode.getProcessedOpinion());//办理结果描述
            apasInfo.setAbnCause(nextNode.getRemark());//作废或退回原因
        }
        body.setApasInfo(apasInfo);
        body.setLicenses(finishCaseEntity.getBody().getLicenses());


        //设置表单信息
//        body.setFormInfos(finishCaseEntity.getBody().getFormInfos());
        // 普通附件信息
        InitialAttr[] finishAttrsData = finishCaseEntity.getBody().getAttrs().getFinishAttrs();
        if (ObjectUtils.isNotEmpty(finishAttrsData)) {
            Attrs attrs = new Attrs();
            FinishAttr[] finishAttrArray= new FinishAttr[finishAttrsData.length];
            for (int i = 0; i < finishAttrsData.length; i++) {
                FinishAttr finishAttr = new FinishAttr();
                finishAttr.setAttrName(finishAttrsData[i].getName());
                finishAttr.setAttrUNID(finishAttrsData[i].getUnid());
                finishAttr.setCertificateHolderCode(finishAttrsData[i].getCertificateHolderCode());
                finishAttr.setCertificateTypeCode(finishAttrsData[i].getCertificateTypeCode());
                finishAttr.setDatashare(finishAttrsData[i].getDatashare());
                finishAttr.setFileName(finishAttrsData[i].getFileName());
                finishAttr.setLicenseIdentifier(finishAttrsData[i].getLicenseIdentifier());
                finishAttr.setSrcCode(finishAttrsData[i].getCode());
                finishAttr.setSwbCode(finishAttrsData[i].getCode());
                finishAttr.setDataId(finishUuid);
                finishAttrArray[i] = finishAttr;
                convertTask.finishXmlMapper.insertAttr(finishAttr);
            }

            attrs.setAttrs(finishAttrArray);
            body.setAttrs(attrs);
//
//            int len = finishAttrsData.length;
//            if (len > 0) {
//                InitialAttr[] attrs = finishAttrsData;
//                List<FinishAttr> finishFinishAttrs = new ArrayList<>();
//                FinishAttr finishAttr = null;
//                List<com.tch.system.entity.convert2xml.Attr> wsspAttrs = wsspInfo.getBody().getAttrs();
//                for (int i = 0; i < len; i++) {
//                     for (com.tch.system.entity.convert2xml.Attr wsspAttr : wsspAttrs) {
//                        finishAttr = new FinishAttr();
//                        finishAttr.setAttrMode(attrs[i].getMode());
//                        finishAttr.setAttrName(attrs[i].getName());
//                        finishAttr.setAttrUNID(attrs[i].getUnid());
//                        finishAttr.setCertificateHolderCode(attrs[i].getCertificateHolderCode());
//                        finishAttr.setCertificateTypeCode(attrs[i].getCertificateTypeCode());
//                        finishAttr.setDatashare(attrs[i].getDatashare());
//                        finishAttr.setFileName(attrs[i].getFileName());
//                        finishAttr.setLicenseIdentifier(attrs[i].getLicenseIdentifier());
//                        if (attrs[i].getMode() != null && attrs[i].getMode().equals("upload")) {
//                            finishAttr.setSort(String.valueOf(i));
//                        }
//                        finishAttr.setSrcCode(wsspAttr.getSrcCode());//原系统的申报材料编码
//                        finishAttr.setSwbCode(wsspAttr.getSwbCode());//省网办的申报材料编码
//                        finishFinishAttrs.add(finishAttr);
//
//                        finishAttr.setDataId(finishUuid);
//                        convertTask.finishXmlMapper.insertAttr(finishAttr);
//                    }
//                }
//                Attrs attrList = new Attrs();
//                attrList.setAttrs(finishFinishAttrs.toArray((new FinishAttr[finishFinishAttrs.size()])));
//                body.setAttrs(attrList);
//            }
        }

        //审批结果附件信息
        body.setResultAttrs(finishCaseEntity.getBody().getResultAttrs());
        CovertDocuments documents = new CovertDocuments();
        //过程单据
        if (finishCaseEntity.getBody().getDocuments() != null && finishCaseEntity.getBody().getDocuments().getDocument() != null && finishCaseEntity.getBody().getDocuments().getDocument().length > 0) {
            int length = finishCaseEntity.getBody().getDocuments().getDocument().length;
            CovertDocument covertDocument = null;
            FinishDocument finishDocument = null;
            CovertDocument[] wsspInfoCovertDocument = wsspInfo.getBody().getDocuments().getDocument();
            List<CovertDocument> covertDocumentList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                CovertDocument wsspCovertDocument = wsspInfoCovertDocument[i];
                finishDocument = finishCaseEntity.getBody().getDocuments().getDocument()[i];
                covertDocument = new CovertDocument();
                covertDocument.setDocName(finishDocument.getName());
                covertDocument.setDocNo(finishDocument.getDocNo());
                covertDocument.setDocType(finishDocument.getType());
                covertDocument.setDocUNID(finishDocument.getUnid());
                covertDocument.setSrcType(wsspCovertDocument.getSrcType());//源系统的单据类型 todo 需确认两边如何对照
                covertDocument.setSwbType(finishDocument.getType());//省网办的单据类型,看文档应该是回流的类型一致
                covertDocumentList.add(covertDocument);

                covertDocument.setDataId(finishUuid);
              convertTask.wsspXmlMapper.insertDocument(covertDocument);
            }
            CovertDocument[] covertDocumentArray = covertDocumentList.toArray(new CovertDocument[0]);
            documents.setCovertDocument(covertDocumentArray);
        }
        body.setDocuments(documents);
        FinishSMS sms = finishCaseEntity.getBody().getSms();
        body.setSms(sms);

        convertEntity.setFinishBody(body);
        // 将Case对象转换为XML字符串
        String xmlString = CaseXmlConverter.convertToXml(convertEntity);
        // 移除 standalone 属性
        xmlString = xmlString.replace(" standalone=\"yes\"", "");
        logger.info("审批结果信息xml:" + xmlString);


      convertTask.wsspXmlMapper.insertConvertEntity(convertEntity);

        router.setDataId(finishUuid);
      convertTask.wsspXmlMapper.insertRouter(router);

        apasInfo.setBusISysInfoUuid(finishUuid);
        convertTask.finishXmlMapper.insertApasInfo(apasInfo);

        if (ObjectUtils.isNotEmpty(sms)) {
            sms.setBusISysInfoUuid(finishUuid);
            convertTask.finishXmlMapper.insertFinishSMS(sms);
        }

        if (ObjectUtils.isNotEmpty(body.getLicenses())
                && ObjectUtils.isNotEmpty(body.getLicenses().getLicense())) {
            FinishLicenses licenses = body.getLicenses();
            FinishLicense[] license = licenses.getLicense();
            for (FinishLicense finishLicense : license) {
                finishLicense.setBusISysInfoUuid(finishUuid);
                convertTask.finishXmlMapper.insertFinishLicense(finishLicense);
            }

        }
        if (ObjectUtils.isNotEmpty(body.getResultAttrs())
                && ObjectUtils.isNotEmpty(body.getResultAttrs().getResultAttrs())) {
            FinishResultAttrs resultAttrs = body.getResultAttrs();
            FinishResultAttr[] resultAttrs1 = resultAttrs.getResultAttrs();
            for (FinishResultAttr finishResultAttr : resultAttrs1) {
                finishResultAttr.setBusISysInfoUuid(finishUuid);
                convertTask.finishXmlMapper.insertFinishResultAttr(finishResultAttr);
            }

        }

        return xmlString;
    }
}