package com.tch.quartz.task;

import com.tch.common.enums.*;
import com.tch.common.utils.StringUtils;
import com.tch.common.utils.bean.BeanUtils;
import com.tch.common.utils.uuid.IdUtils;
import com.tch.system.constants.Constants;
import com.tch.system.domain.DnTaskBasic;
import com.tch.system.entity.common.*;
import com.tch.system.entity.convert2xml.*;
import com.tch.system.entity.wsspxml.OriginCaseEntity;
import com.tch.system.entity.wsspxml.WsspExtend;
import com.tch.system.mapper.WsspXmlMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.tch.system.util.CaseXmlConverter.convertToXml;

/**
 * @author duanjunlong
 * @data 2024/3/21 15:25
 */
@Component
public class ConvertWsspTask {
    @Resource
    private WsspXmlMapper wsspXmlMapper;


    public static ConvertWsspTask convertWsspTask;


    @PostConstruct
    public void init() {
        convertWsspTask = this;
        convertWsspTask.wsspXmlMapper = this.wsspXmlMapper;
    }


    public static String createWsspData(OriginCaseEntity convertEntity, String unid, Logger logger, DnTaskBasic dnTaskBasic) {

        ConvertEntity caseObj = new ConvertEntity();
        caseObj.setApplyFrom(DocumentsBase.checkKeyExists(convertEntity.getApplyFrom()));
        caseObj.setType(TypeConversion.checkKeyExists(convertEntity.getType()));
        caseObj.setUnid(unid);
        caseObj.setXsd(convertEntity.getXsd());


        //  路由信息
        Router router = new Router();
        router.setFromAreaCode(Constants.FromAreaCode);
        router.setFromAreaName(Constants.FromAreaName);
        router.setToAreaCode(Constants.FromAreaCode);
        router.setToAreaName(Constants.ToAreaName);
        router.setTargetSystem(Constants.TargetSystem);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        router.setSendTime(date);
        router.setPrevLinkUNID("0");//上一环节unid
        caseObj.setRouter(router);


        ConvertBody body = new ConvertBody();
        ConvertEntityApasInfo apasInfo = new ConvertEntityApasInfo();
        com.tch.system.entity.wsspxml.ApasInfo convertApasInfo = convertEntity.getBody().getApasInfo();

        if (StringUtils.isNotEmpty(convertApasInfo.getProjectCode())) {
            apasInfo.setProjectCode(convertApasInfo.getProjectCode());//项目投资使用
        }


        apasInfo.setSwbServiceID(dnTaskBasic.getOlditemId());//省网上办事大厅的审批事项主键ID
        apasInfo.setSrcMatterID(dnTaskBasic.getTaskHandleItem()); // 原系统的审批事项编号
        apasInfo.setAreaCode(dnTaskBasic.getRegionCode().substring(0, 6));//审批事项所属区划代码
        apasInfo.setReceiveDeptName(dnTaskBasic.getDeptName());// 实施部门
        apasInfo.setReceiveDeptCode(dnTaskBasic.getDeptCode());// 实施部门信用代码

        // 办件收件基本信息
        //原系统代码 是来源系统代码  是一致的 是我们这边生成的 SGA-
        apasInfo.setFromCode(Constants.FromAreaCode);//申报原系统代码
        apasInfo.setSwbMatterID(convertApasInfo.getServiceCode());


        apasInfo.setSwbServiceType(AssortConvert.checkKeyExists(dnTaskBasic.getAssort()));//办件类型
        apasInfo.setSwbMatteType(dnTaskBasic.getTaskType());//事项类型

        apasInfo.setSwbMatterName(convertApasInfo.getProjectName());
        apasInfo.setProjectName(convertApasInfo.getProjectName());
        //apasInfo.setProjectName("测试");
        apasInfo.setPromiseDay(convertApasInfo.getPromiseDay());//承诺时限
        apasInfo.setPromiseDayUnit(convertApasInfo.getReceiveDeptName());
        apasInfo.setSwbSN(convertApasInfo.getSn());
        apasInfo.setSrcSN(convertApasInfo.getSn());//原系统申报号
        apasInfo.setVersion(1);// 数据版本号
        apasInfo.setPwd(convertApasInfo.getPwd());
        apasInfo.setDeclareTime(convertApasInfo.getDeclareTime());

        apasInfo.setAcceptAddress("");//受理具体地点
        apasInfo.setSubWay(0);//默认为0  提交方式
        apasInfo.setQueuingNo("");//窗口排队号
        apasInfo.setCentralApprovalItemid(convertApasInfo.getCentralApprovalItemid());
        apasInfo.setRelItemFlag(convertApasInfo.getRelItemFlag());//默认为0 地方中央协办标识
        apasInfo.setRelDeptCode(convertApasInfo.getRelDeptCode());
        apasInfo.setRelCentralItemCode(convertApasInfo.getRelCentralItemCode());
        apasInfo.setClassUnid(convertApasInfo.getClassUnid());
        apasInfo.setClassName(convertApasInfo.getClassName());
        apasInfo.setTysjm(convertApasInfo.getTysjm());
        body.setApasInfo(apasInfo);


        //申报对象信息
        Proposer proposer = new Proposer();
        com.tch.system.entity.wsspxml.Proposer convertProposer = convertEntity.getBody().getProposer();

        Person convertPerson = convertProposer.getPerson();
        proposer.setApplyType(convertProposer.getApplyType());
        proposer.setApplyObjAreaCode(convertProposer.getAreaCode());

        //判断是法人业务还是个人业务  0是个人 1是法人
        if (convertProposer.getApplyType().equals(Constants.DECLARE_TYPE_CORPORATION)) {
            // 申报对象为法人时，则必填
            Unit unit = new Unit();
            com.tch.system.entity.wsspxml.Unit convertUnit = convertProposer.getUnit();
            unit.setUnitName(convertUnit.getUnitName());//机构名称
            unit.setUnitCode(convertUnit.getUnitCode());//机构代码
            unit.setUnitType(convertUnit.getUnitType());//机构类型
            unit.setUnitIdcardType(convertUnit.getUnitIdcardType());//机构证件类型
            unit.setLealPerson(convertUnit.getLealPerson());//法定代表
            unit.setLegalIdcardType(convertUnit.getLegalIdcardType());//法定代表人证件类型
            unit.setLegalIdcard(convertUnit.getLegalIdcard());//法定代表人证件号码
            unit.setUnitAddress(convertUnit.getAddress());//通讯地址
            unit.setUnitTel(convertUnit.getTel());//联系电话
            unit.setUnitPostcode(convertUnit.getPostcode());//邮政编码
            unit.setCompanyPhone(convertUnit.getCompanyPhone());//单位联系方式
            proposer.setUnit(unit);


        } else {
            //申报对象为个人时，则必填
            Person person = new Person();
            person.setApplyName(convertPerson.getApplyName());//申请人名称
            person.setSex(convertPerson.getSex());//性别
            person.setBirthday(convertPerson.getBirthday());//出生日期
            person.setCertificateType(convertPerson.getCertificateType());//证件类型
            person.setCertificateName(convertPerson.getCertificateName());//证件名称
            person.setCertificateNumber(convertPerson.getCertificateNumber());//证件号码
            person.setAddress(convertPerson.getAddress());//证件号码
            person.setPostcode(convertPerson.getPostcode());//邮政编码
            person.setMobilePhone(convertPerson.getMobilePhone());//手机号码
            person.setMail(convertPerson.getMail());//电子邮箱
            person.setTel(convertPerson.getTel());//电子邮箱
            proposer.setPerson(person);
        }
        body.setProposer(proposer);


        //必填，经办人（联系人）信息
        Operator operator = new Operator();
        com.tch.system.entity.wsspxml.Operator convertOperator = convertEntity.getBody().getOperator();

        operator.setOperatorApplyName(convertOperator.getName());
        operator.setOperatorSex(convertOperator.getSex());
        operator.setOperatorBirthday(convertOperator.getBirthday());
        operator.setOperatorCertificateType(convertOperator.getCertificateType());
        operator.setOperatorCertificateName(IDType.checkKeyExists(convertOperator.getCertificateType()));
        operator.setOperatorCertificateNumber(convertOperator.getCertificateNumber());
        operator.setOperatorAddress(convertOperator.getAddress());
        operator.setOperatorPostcode(convertOperator.getPostcode());
        operator.setOperatorMobilePhone(convertOperator.getMobilePhone());
        operator.setOperatorMail(convertOperator.getMail());
        operator.setOperatorTel(convertOperator.getTel());
        body.setOperator(operator);

        // 办理结果邮寄信息
        Expresses expresses = new Expresses();
        Express express = new Express();
        InitialExpress convertExpress = convertEntity.getBody().getExpresses().getExpress();
        if (ObjectUtils.isNotEmpty(convertExpress)) {
            BeanUtils.copyBeanProp(convertExpress, express);
            body.setExpresses(expresses);
        } else {
            express.setrAddress("");
            express.setrAreaCode("");
            express.setrCity("");
            express.setRecipients("");
            express.setrMobile("");
            express.setrContactNumber("");
            express.setrPayType("");
            expresses.setExpress(express);
            body.setExpresses(expresses);
        }


        if (ObjectUtils.isNotEmpty(convertEntity.getBody().getFormInfos())) {//说明是投资监管项目
            // body.setFormInfos(convertEntity.getBody().getFormInfos());
            CovertFormInfo[] covertFormInfos = convertEntity.getBody().getFormInfos().getFormInfos();
            for (CovertFormInfo covertFormInfo : covertFormInfos) {
                //设置表单信息id  资监管项目时有此部分信息
                String specialLenId = IdUtils.getSpecialLenId(20);
                covertFormInfo.setFormInfoId(specialLenId);
                //关联对应的办件信息
                covertFormInfo.setBusISysInfoUuid(unid);
                //获取扩展信息
                CovertItem[] covertItems = covertFormInfo.getItems();
                convertWsspTask.wsspXmlMapper.insertFormInfo(covertFormInfo);
                for (CovertItem covertItem : covertItems) {
                    //扩展信息和资监管项目信息进行关联
                    covertItem.setDataId(specialLenId);
                    convertWsspTask.wsspXmlMapper.insertItem(covertItem);
                }

            }

        }


        ConvertAttrs convertAttrs = new ConvertAttrs();
        convertAttrs.setAttrList(new ArrayList<>());//列表初始化
        List<InitialAttr> originAttrList = convertEntity.getBody().getAttrs().getAttrList();
        if (originAttrList != null && !originAttrList.isEmpty()) {
            for (InitialAttr at : originAttrList) {
                com.tch.system.entity.convert2xml.Attr attr = new com.tch.system.entity.convert2xml.Attr();
                attr.setAttrUNID(at.getUnid());
                attr.setAttrMode(at.getMode());
                attr.setSwbCode(at.getCode());
                attr.setName(at.getName());
                attr.setDataId(unid);

                if (at.getMode().equals("upload")) {//当mode=’ sharelib’ 时使用，并上传1.2.9共享材料应用数据
                    attr.setSort(at.getSeqNo());
                } else if (at.getMode().equals("sharelib")) {//当mode=’ sharelib’ 并上传1.2.9共享材料应用数据
                    attr.setDatashare(at.getDatashare());
                    attr.setLicenseIdentifier(at.getLicenseIdentifier());
                } else if (at.getMode().equals("license")) {//证照类型代码，当mode=“license”时使用
                    attr.setFileName(at.getFileName());
                    attr.setCertificateTypeCode(at.getCertificateTypeCode());
                    attr.setCertificateHolderCode(at.getCertificateHolderCode());
                } else {
                    attr.setSort("");
                }

                attr.setDatashare("");//享材料应用ID 由汇聚平台或者数据提供方共享数据时提供
                attr.setLicenseIdentifier(at.getLicenseIdentifier());
                attr.setCertificateTypeCode(at.getCertificateTypeCode());
                attr.setCertificateHolderCode(at.getCertificateHolderCode());
                convertAttrs.getAttrList().add(attr);


                convertWsspTask.wsspXmlMapper.insertAttr(attr);
            }
            body.setAttrs(convertAttrs.getAttrList());
        }


        Documents documents = new Documents();
        if (convertEntity.getBody().getDocuments() != null && convertEntity.getBody().getDocuments().getDocument() != null && convertEntity.getBody().getDocuments().getDocument().length > 0) {
            int length = convertEntity.getBody().getDocuments().getDocument().length;
            CovertDocument covertDocument = null;
            com.tch.system.entity.wsspxml.Document wsspDocument = null;

            List<CovertDocument> covertDocumentList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                wsspDocument = convertEntity.getBody().getDocuments().getDocument()[i];
                covertDocument = new CovertDocument();
                covertDocument.setDocUNID(wsspDocument.getUnid());
                covertDocument.setSwbType(DocumentConversion.checkKeyExists(wsspDocument.getType()));
                covertDocument.setSrcType(wsspDocument.getType());
                covertDocument.setDocType(wsspDocument.getType());
                covertDocument.setDocName(wsspDocument.getName());
                covertDocument.setDocNo(wsspDocument.getDocNo());
                covertDocument.setDataId(unid);
                covertDocumentList.add(covertDocument);
                convertWsspTask.wsspXmlMapper.insertDocument(covertDocument);
            }
            // 将集合转换为数组
            CovertDocument[] covertDocumentArray = covertDocumentList.toArray(new CovertDocument[0]);
            documents.setDocument(covertDocumentArray);
        }
        body.setDocuments(documents);


        //<!--可选，通知信息 -->
        Sms sms = new Sms();
        com.tch.system.entity.wsspxml.Sms convertSms = convertEntity.getBody().getSms();
        if (ObjectUtils.isNotEmpty(convertSms)) {
            sms.setSmsReceiver(convertSms.getReceiver());
            sms.setSmsAddress(convertSms.getAddress());
            sms.setSmsContent(convertSms.getContent());
            body.setSms(sms);
        }


        // <!-- 云表单地址 -->
        CloudForm convertCloudForm = convertEntity.getBody().getCloudForm();
        if (ObjectUtils.isNotEmpty(convertCloudForm)) {
            body.setCloudForm(convertCloudForm);
            convertCloudForm.setBusISysInfoUuid(unid);
            convertWsspTask.wsspXmlMapper.insertCloudForm(convertCloudForm);
        } else {
            CloudForm cloudForm = new CloudForm();
            cloudForm.setIntranetUrl("");
            cloudForm.setOuternetUrl("");
            body.setCloudForm(cloudForm);
        }


        //<!--可选，办件扩展信息 -->
        Extend extend = new Extend();
        WsspExtend convertExtend = convertEntity.getBody().getExtend();
        if (ObjectUtils.isNotEmpty(convertExtend)) {
            extend.setIsAgentService(convertExtend.getIsAgentService());
            extend.setAgentServiceCharge(convertExtend.getAgentServiceCharge());
            extend.setBackflow(convertExtend.getBackflow());
            extend.setGzcnspFlag(convertExtend.getGzcnspFlag());
            extend.setGzcnspFileUnid(convertExtend.getGzcnspFileUnid());
            extend.setGzcnspFileName(convertExtend.getGzcnspFileName());

            extend.setAgentSourceArea(convertExtend.getAgentSourceArea());
            extend.setCertifiedIsWriteOff(convertExtend.getCertifiedIsWriteOff());
            extend.setBusISysInfoUuid(unid);
            extend.setBackflowSystem("");
            convertWsspTask.wsspXmlMapper.insertExtend(extend);

        } else {
            extend.setIsAgentService("");
            extend.setAgentServiceCharge("");
            extend.setBackflow("");
            extend.setGzcnspFlag("");
            extend.setGzcnspFileUnid("");
            extend.setGzcnspFileName("");
            extend.setAgentSourceArea("");
            extend.setCertifiedIsWriteOff("");
            extend.setBackflowSystem("");

        }
        body.setExtend(extend);


        caseObj.setBody(body);
        String xmlString = convertToXml(caseObj);
        xmlString = xmlString.replace(" standalone=\"yes\"", "");
        logger.info("审批结果信息xml:" + xmlString);
        //进行入库操作
        insertWsspData(unid, caseObj, router, apasInfo, proposer, operator, express, sms);
        return xmlString;
    }

    //入库
    private static void insertWsspData(String unid, ConvertEntity caseObj, Router router, ConvertEntityApasInfo convertApasInfo, Proposer proposer, Operator operator, Express express, Sms sms) {
        convertWsspTask.wsspXmlMapper.insertConvertEntity(caseObj);

        router.setDataId(unid);
        convertWsspTask.wsspXmlMapper.insertRouter(router);

        convertApasInfo.setBusISysInfoUuid(unid);
        convertWsspTask.wsspXmlMapper.insertApasInfo(convertApasInfo);

        if (ObjectUtils.isNotEmpty(proposer)) {
            proposer.setBusISysInfoUuid(unid);
            convertWsspTask.wsspXmlMapper.insertProposer(proposer);
            if (ObjectUtils.isNotEmpty(proposer.getPerson())){
                Person person = proposer.getPerson();
                person.setDataId(unid);
                convertWsspTask.wsspXmlMapper.insertPerson(person);
            }
            if (ObjectUtils.isNotEmpty(proposer.getUnit())){
                Unit unit = proposer.getUnit();
                unit.setDataId(unid);
                convertWsspTask.wsspXmlMapper.insertUnit(unit);

            }
        }

        if (ObjectUtils.isNotEmpty(operator)) {
        operator.setBusISysInfoUuid(unid);
        convertWsspTask.wsspXmlMapper.insertOperator(operator);
        }

        if (ObjectUtils.isNotEmpty(express)) {
        express.setBusISysInfoUuid(unid);
        convertWsspTask.wsspXmlMapper.insertExpress(express);
        }

        if (ObjectUtils.isNotEmpty(sms)) {
        sms.setBusISysInfoUuid(unid);
        convertWsspTask.wsspXmlMapper.insertSms(sms);
        }

    }

}
