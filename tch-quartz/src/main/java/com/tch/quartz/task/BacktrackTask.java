package com.tch.quartz.task;

import com.tch.common.utils.uuid.IdUtils;
import com.tch.system.constants.Constants;
import com.tch.system.domain.TBusisysinfo;
import com.tch.system.domain.TResourceInfo;
import com.tch.system.entity.common.*;
import com.tch.system.entity.convert2xml.*;
import com.tch.system.entity.finish2xml.FinishApasInfo;
import com.tch.system.entity.finish2xml.FinishAttr;
import com.tch.system.entity.finish2xml.ResultCaseEntity;
import com.tch.system.entity.next2xml.Attrs;
import com.tch.system.entity.next2xml.NextCaseEntity;
import com.tch.system.entity.next2xml.NextConvertApasInfo;
import com.tch.system.entity.next2xml.NextNode;
import com.tch.system.entity.xml2bean.*;
import com.tch.system.mapper.*;
import com.tch.system.util.CaseXmlConverter;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/11 12:28
 */

@Component("backtrackTask")
public class BacktrackTask {


    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TBusisysinfoMapper tBusisysinfoMapper;


    @Resource
    private TResourceInfoMapper tResourceInfoMapper;

    @Resource
    private WsspXmlMapper wsspXmlMapper;

    @Resource
    private NextXmlMapper nextXmlMapper;

    @Resource
    private FinishXmlMapper finishXmlMapper;


    public void traceData() {
        try {
            //查询出tchar4字段没有操作的数据查询出办件数据 限制为1000条
            List<TBusisysinfo> tBusisysinfo = tBusisysinfoMapper.selectTBusisysinfoDataList();
//            ArrayList<TBusisysinfo> tBusisysinfos = new ArrayList<>();
            for (TBusisysinfo busisysinfo : tBusisysinfo) {
                //查询数据
                selectGetTChar1(busisysinfo);
                //操作完给业务系统的数据备用字段注入标识  标识已经操作 避免重复操作
                busisysinfo.setTchar4(Constants.OPERATION_LOGO_1);
//                tBusisysinfos.add(busisysinfo);
                System.out.println("信息操作成功: " + busisysinfo.getUnid());
                tBusisysinfoMapper.updateTBusisysinfo(busisysinfo);
            }

//            if (!tBusisysinfos.isEmpty()){
//                //进行批量更新
//                tBusisysinfoMapper.updateTBusisysinfoByIdList(tBusisysinfos);
//            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }


    }

    /**
     * 更具备用字符字段1 查询数据
     *
     * @param busisysinfo 业务系统的数据
     */
    public void selectGetTChar1(TBusisysinfo busisysinfo) {
        //查询出否有两条办件放回 成功的数据
        List<TResourceInfo> tResourceInfos = tResourceInfoMapper.selectTResourceInfoDataList(busisysinfo.getUnid());
        if (!tResourceInfos.isEmpty()) {
            if (tResourceInfos.size() == 2) {//数量等于2  说明市里通过审核 只需要看省厅返回的数据即可
                //判断是什么类型的办件
                decideType(busisysinfo, Constants.OPERATION_LOGO_1);
            } else {
                decideType(busisysinfo, Constants.OPERATION_LOGO_2);
            }

        }

    }

    /**
     * * 判断办件类型
     *
     * @param busisysinfo 业务系统的数据
     */

    public void decideType(TBusisysinfo busisysinfo, String operationLogo) {
        byte[] content = busisysinfo.getContent();
        //进行转义
        String str = new String(content, StandardCharsets.UTF_8);
        String type = busisysinfo.getType();
        if (type.equals(Constants.BJXX_TYPE)) {//办件信息
            backtrackWsspXml(str, operationLogo);
        } else if (type.equals(Constants.GCXX_TYPE)) {//过程信息
            backtrackNextXml(str, operationLogo);
        } else {//结果信息
            backtrackFinishXml(str, operationLogo);

        }
    }


    //拆分办件数据入库
    public void backtrackWsspXml(String content, String operationLogo) {
        //进行实体类转义
        ConvertEntity convertEntity = (ConvertEntity) CaseXmlConverter.parseXml(content, new ConvertEntity());
        //判断实体不为空
        if (ObjectUtils.isNotEmpty(convertEntity)) {


            String unId = convertEntity.getUnid();
            System.out.println("办件id: " + unId);
            setConvertBaseData(convertEntity, operationLogo);

            ConvertBody convertBody = convertEntity.getBody();
            Router router = convertEntity.getRouter();
            router.setDataId(unId);
            wsspXmlMapper.insertRouter(router);

            ConvertEntityApasInfo apasInfo = convertBody.getApasInfo();
            apasInfo.setBusISysInfoUuid(unId);
            wsspXmlMapper.insertApasInfo(apasInfo);


            //说明是投资监管项目
            if (ObjectUtils.isNotEmpty(convertBody.getFormInfos()) &&
                    ObjectUtils.isNotEmpty(convertBody.getFormInfos().getFormInfos())) {
                CovertFormInfo[] covertFormInfos = convertBody.getFormInfos().getFormInfos();
                setCovertFormInfos(unId, covertFormInfos);
            }

            List<Attr> attrs = convertBody.getAttrs();
            if (ObjectUtils.isNotEmpty(attrs)) {
                for (Attr attr : attrs) {
                    attr.setDataId(unId);
                    wsspXmlMapper.insertAttr(attr);

                }

            }

            Documents documents = convertBody.getDocuments();
            if (ObjectUtils.isNotEmpty(documents) && ObjectUtils.isNotEmpty(documents.getDocument())) {
                for (CovertDocument covertDocument : documents.getDocument()) {
                    covertDocument.setDataId(unId);
                    wsspXmlMapper.insertDocument(covertDocument);
                }
            }


            Proposer proposer = convertBody.getProposer();
            if (ObjectUtils.isNotEmpty(proposer)) {
                proposer.setBusISysInfoUuid(unId);
                wsspXmlMapper.insertProposer(proposer);

                if (ObjectUtils.isNotEmpty(proposer.getPerson())){
                    Person person = proposer.getPerson();
                    person.setDataId(unId);
                    wsspXmlMapper.insertPerson(person);
                }
                if (ObjectUtils.isNotEmpty(proposer.getUnit())){
                    Unit unit = proposer.getUnit();
                    unit.setDataId(unId);
                    wsspXmlMapper.insertUnit(unit);

                }
            }
            Operator operator = convertBody.getOperator();
            if (ObjectUtils.isNotEmpty(operator)) {
                operator.setBusISysInfoUuid(unId);
                wsspXmlMapper.insertOperator(operator);
            }
            Extend extend = convertBody.getExtend();
            if (ObjectUtils.isNotEmpty(extend)) {
                extend.setBusISysInfoUuid(unId);
                wsspXmlMapper.insertExtend(extend);
            }

            Sms sms = convertBody.getSms();
            if (ObjectUtils.isNotEmpty(sms)) {
                sms.setBusISysInfoUuid(unId);
                wsspXmlMapper.insertSms(sms);
            }

            CloudForm cloudForm = convertBody.getCloudForm();
            if (ObjectUtils.isNotEmpty(cloudForm)) {
                cloudForm.setBusISysInfoUuid(unId);
                wsspXmlMapper.insertCloudForm(cloudForm);
            }

            Express express = convertBody.getExpresses().getExpress();
            if (ObjectUtils.isNotEmpty(express)) {
                express.setBusISysInfoUuid(unId);
                wsspXmlMapper.insertExpress(express);

            }
        }


    }

    //拆分过程数据入库
    public void backtrackNextXml(String content, String operationLogo) {
        NextCaseEntity nextCaseEntity = (NextCaseEntity) CaseXmlConverter.parseXml(content, new NextCaseEntity());
        if (ObjectUtils.isNotEmpty(nextCaseEntity)) {

            String unid = nextCaseEntity.getUnid();
            setConvertBaseData(nextCaseEntity, operationLogo);

            System.out.println("办件过程id: " + unid);
            Router router = nextCaseEntity.getRouter();
            router.setDataId(unid);
            wsspXmlMapper.insertRouter(router);

            NextConvertApasInfo apasInfo = nextCaseEntity.getBody().getApasInfo();
            apasInfo.setBusISysInfoUuid(unid);
            nextXmlMapper.insertNextApasInfo(apasInfo);

            NextNode node = nextCaseEntity.getBody().getNode();
            node.setBusISysInfoUuid(unid);
            nextXmlMapper.insertNextNode(node);

            CovertDocument[] covertDocument = node.getDocuments().getCovertDocument();
            if (ObjectUtils.isNotEmpty(covertDocument)) {
                for (CovertDocument document : covertDocument) {
                    document.setDataId(unid);
                    wsspXmlMapper.insertDocument(document);
                }
            }
            Attrs attrs = node.getAttrs();
            if (ObjectUtils.isNotEmpty(attrs) && ObjectUtils.isNotEmpty(attrs.getAttrList())) {
                for (com.tch.system.entity.next2xml.Attr attr : attrs.getAttrList()) {
                    attr.setDataId(unid);
                    nextXmlMapper.insertNextAttr(attr);
                }
            }




        }

    }

    //拆分结果信息入库
    public void backtrackFinishXml(String content, String operationLogo) {
        ResultCaseEntity resultCaseEntity = (ResultCaseEntity) CaseXmlConverter.parseXml(content, new ResultCaseEntity());

        if (ObjectUtils.isNotEmpty(resultCaseEntity)) {
            String unid = resultCaseEntity.getUnid();

            System.out.println("办件结果id: " + unid);
            setConvertBaseData(resultCaseEntity, operationLogo);

            Router router = resultCaseEntity.getRouter();
            router.setDataId(unid);
            wsspXmlMapper.insertRouter(router);

            FinishApasInfo apasInfo = resultCaseEntity.getFinishBody().getApasInfo();
            apasInfo.setBusISysInfoUuid(unid);
            finishXmlMapper.insertApasInfo(apasInfo);



            if (ObjectUtils.isNotEmpty(resultCaseEntity.getFinishBody().getSms())){
                FinishSMS sms = resultCaseEntity.getFinishBody().getSms();
                sms.setBusISysInfoUuid(unid);
                finishXmlMapper.insertFinishSMS(sms);
            }



            CovertDocument[] document = resultCaseEntity.getFinishBody().getDocuments().getCovertDocument();
            if (ObjectUtils.isNotEmpty(document)) {
                for (CovertDocument covertDocument : document) {
                    covertDocument.setDataId(unid);
                    wsspXmlMapper.insertDocument(covertDocument);
                }
            }


            com.tch.system.entity.finish2xml.Attrs attrs = resultCaseEntity.getFinishBody().getAttrs();
            if (ObjectUtils.isNotEmpty(attrs) && ObjectUtils.isNotEmpty(attrs.getAttrs())) {
                for (FinishAttr attr : attrs.getAttrs()) {
                    attr.setDataId(unid);
                    finishXmlMapper.insertAttr(attr);
                }
            }

            if (ObjectUtils.isNotEmpty(resultCaseEntity.getFinishBody().getLicenses())
                    &&ObjectUtils.isNotEmpty(resultCaseEntity.getFinishBody().getLicenses().getLicense())){
                FinishLicenses licenses = resultCaseEntity.getFinishBody().getLicenses();
                FinishLicense[] license = licenses.getLicense();
                for (FinishLicense finishLicense : license) {
                    finishLicense.setBusISysInfoUuid(unid);
                    finishXmlMapper.insertFinishLicense(finishLicense);
                }

            }


            //判断是否投资项目
            if (resultCaseEntity.getFinishBody().getFormInfos() != null
                    && resultCaseEntity.getFinishBody().getFormInfos().getFormInfos() != null) {//说明是投资监管项目
                CovertFormInfo[] covertFormInfos = resultCaseEntity.getFinishBody().getFormInfos().getFormInfos();
                setCovertFormInfos(unid, covertFormInfos);

            }

            if (ObjectUtils.isNotEmpty(resultCaseEntity.getFinishBody().getResultAttrs())
                    &&ObjectUtils.isNotEmpty(resultCaseEntity.getFinishBody().getResultAttrs().getResultAttrs())){
                FinishResultAttrs resultAttrs = resultCaseEntity.getFinishBody().getResultAttrs();
                FinishResultAttr[] resultAttrs1 = resultAttrs.getResultAttrs();
                for (FinishResultAttr finishResultAttr : resultAttrs1) {
                    finishResultAttr.setBusISysInfoUuid(unid);
                    finishXmlMapper.insertFinishResultAttr(finishResultAttr);
                }

            }

        }
    }

    public void setConvertBaseData(ConvertBaseData data, String operationLogo) {
        if (operationLogo.equals(Constants.OPERATION_LOGO_2)) {
            data.setOperationLogo(Constants.OPERATION_LOGO_2);
            data.setResourceInfoType(Constants.RESOURCE_INFO_TYPE_999);
        } else {
            data.setOperationLogo(Constants.OPERATION_LOGO_1);
            data.setResourceInfoType(Constants.RESOURCE_INFO_TYPE_99);
        }
        wsspXmlMapper.insertConvertEntity(data);
    }


    private void setCovertFormInfos(String unId, CovertFormInfo[] covertFormInfos) {
        for (CovertFormInfo covertFormInfo : covertFormInfos) {
            //设置表单信息id  资监管项目时有此部分信息
            String specialLenId = IdUtils.getSpecialLenId(20);
            covertFormInfo.setFormInfoId(specialLenId);
            //关联对应的办件信息
            covertFormInfo.setBusISysInfoUuid(unId);
            //获取扩展信息
            CovertItem[] covertItems = covertFormInfo.getItems();
            wsspXmlMapper.insertFormInfo(covertFormInfo);
            for (CovertItem covertItem : covertItems) {
                //扩展信息和资监管项目信息进行关联
                covertItem.setDataId(specialLenId);
                wsspXmlMapper.insertItem(covertItem);
            }

        }
    }
}
