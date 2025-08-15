package com.tch.test;

import com.tch.common.utils.uuid.IdUtils;
import com.tch.system.domain.TBusisysinfo;
import com.tch.system.domain.TResourceInfo;
import com.tch.system.entity.common.*;
import com.tch.system.entity.convert2xml.Attr;
import com.tch.system.entity.convert2xml.ConvertEntity;
import com.tch.system.entity.convert2xml.ConvertEntityApasInfo;
import com.tch.system.entity.convert2xml.Documents;
import com.tch.system.entity.finish2xml.FinishApasInfo;
import com.tch.system.entity.finish2xml.FinishAttr;
import com.tch.system.entity.finish2xml.ResultCaseEntity;
import com.tch.system.entity.next2xml.Attrs;
import com.tch.system.entity.next2xml.NextCaseEntity;
import com.tch.system.entity.next2xml.NextConvertApasInfo;
import com.tch.system.entity.next2xml.NextNode;
import com.tch.system.entity.xml2bean.FinishSMS;
import com.tch.system.mapper.*;
import com.tch.system.util.CaseXmlConverter;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/11 16:13
 */

@SpringBootTest
public class BacktrackTest {

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



    @Test
    public void traceData() {
        //查询出TCHAR4字段没有操作的数据
        List<TBusisysinfo> tBusisysinfo = tBusisysinfoMapper.selectTBusisysinfoDataList();
        for (TBusisysinfo busisysinfo : tBusisysinfo) {
            //查询数据
            selectGetTChar1(busisysinfo);
            //操作完给业务系统的数据备用字段注入标识  标识已经操作 避免重复操作
            busisysinfo.setTchar4("1");
            tBusisysinfoMapper.insertTBusisysinfo(busisysinfo);
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
        if (tResourceInfos.size() >= 2) {//数量大于2  说明市里通过审核 只需要看省厅返回的数据即可
            //判断是什么类型的办件
            decideType(busisysinfo,"1");
        } else {
            decideType(busisysinfo,"2");
        }
    }

    /**
     * * 判断办件类型
     *
     * @param busisysinfo 业务系统的数据
     */

    public void decideType(TBusisysinfo busisysinfo,String operationLogo) {
        byte[] content = busisysinfo.getContent();
        //进行转义
        String str = new String(content, StandardCharsets.UTF_8);
        String type = busisysinfo.getType();
        if (type.equals("210")) {//办件信息
            backtrackWsspXml(str,operationLogo);
        } else if (type.equals("220")) {//过程信息
            backtrackNextXml(str,operationLogo);
        } else {//结果信息
            backtrackFinishXml(str,operationLogo);

        }
    }


    public void backtrackWsspXml(String content,String operationLogo) {
        //进行实体类转义
        ConvertEntity convertEntity = (ConvertEntity) CaseXmlConverter.parseXml(content, new ConvertEntity());
        //判断实体不为空
        if (ObjectUtils.isNotEmpty(convertEntity)) {

            setConvertBaseData(convertEntity,operationLogo);

            String unId = convertEntity.getUnid();

            Router router = convertEntity.getRouter();
            router.setDataId(unId);
            wsspXmlMapper.insertRouter(router);

            ConvertEntityApasInfo apasInfo = convertEntity.getBody().getApasInfo();
            apasInfo.setBusISysInfoUuid(unId);
            wsspXmlMapper.insertApasInfo(apasInfo);

            //说明是投资监管项目
            if (ObjectUtils.isNotEmpty(convertEntity.getBody().getFormInfos())) {
                // body.setFormInfos(convertEntity.getBody().getFormInfos());
                CovertFormInfo[] covertFormInfos = convertEntity.getBody().getFormInfos().getFormInfos();
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

            List<Attr> attrs = convertEntity.getBody().getAttrs();
            if(ObjectUtils.isNotEmpty(attrs)){
                for (Attr attr : attrs) {
                    attr.setDataId(unId);
                    wsspXmlMapper.insertAttr(attr);

            }

            }

            Documents documents = convertEntity.getBody().getDocuments();
            if (ObjectUtils.isNotEmpty(documents)&&ObjectUtils.isNotEmpty(documents.getDocument())){
                for (CovertDocument covertDocument : documents.getDocument()) {
                    covertDocument.setDataId(unId);
                    wsspXmlMapper.insertDocument(covertDocument);
                }
            }

        }


    }


    public void backtrackNextXml(String content,String operationLogo) {
        NextCaseEntity nextCaseEntity = (NextCaseEntity) CaseXmlConverter.parseXml(content, new NextCaseEntity());
        if (ObjectUtils.isNotEmpty(nextCaseEntity)) {

            String unid = nextCaseEntity.getUnid();
            setConvertBaseData(nextCaseEntity,operationLogo);

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
            if (ObjectUtils.isNotEmpty(covertDocument)){
                for (CovertDocument document : covertDocument) {
                    document.setDataId(unid);
                    wsspXmlMapper.insertDocument(document);
                }
            }
            Attrs attrs = node.getAttrs();
            if (ObjectUtils.isNotEmpty(attrs)&&ObjectUtils.isNotEmpty(attrs.getAttrList())){
                for (com.tch.system.entity.next2xml.Attr attr : attrs.getAttrList()) {
                    attr.setDataId(unid);
                    nextXmlMapper.insertNextAttr(attr);
                }
            }

        }

    }

    public void backtrackFinishXml(String content,String operationLogo) {
        ResultCaseEntity resultCaseEntity = (ResultCaseEntity) CaseXmlConverter.parseXml(content, new ResultCaseEntity());

        if (ObjectUtils.isNotEmpty(resultCaseEntity)) {
            String unid = resultCaseEntity.getUnid();

            setConvertBaseData(resultCaseEntity,operationLogo);

            Router router = resultCaseEntity.getRouter();
            router.setDataId(unid);
            wsspXmlMapper.insertRouter(router);

            FinishApasInfo apasInfo = resultCaseEntity.getFinishBody().getApasInfo();
            apasInfo.setBusISysInfoUuid(unid);
            finishXmlMapper.insertApasInfo(apasInfo);


            FinishSMS sms = resultCaseEntity.getFinishBody().getSms();
            sms.setBusISysInfoUuid(unid);
            finishXmlMapper.insertFinishSMS(sms);


            CovertDocument[] document = resultCaseEntity.getFinishBody().getDocuments().getCovertDocument();
            if (ObjectUtils.isNotEmpty(document)){
                for (CovertDocument covertDocument : document) {
                    covertDocument.setDataId(unid);
                    wsspXmlMapper.insertDocument(covertDocument);
                }
            }


            com.tch.system.entity.finish2xml.Attrs attrs = resultCaseEntity.getFinishBody().getAttrs();
            if (ObjectUtils.isNotEmpty(attrs)&&ObjectUtils.isNotEmpty(attrs.getAttrs())){
                for (FinishAttr attr : attrs.getAttrs()) {
                    attr.setDataId(unid);
                    finishXmlMapper.insertAttr(attr);
                }
            }



            //判断是否投资项目
            if (resultCaseEntity.getFinishBody().getFormInfos() != null
                    && resultCaseEntity.getFinishBody().getFormInfos().getFormInfos() != null) {//说明是投资监管项目

                CovertFormInfo[] covertFormInfos = resultCaseEntity.getFinishBody().getFormInfos().getFormInfos();
                for (CovertFormInfo covertFormInfo : covertFormInfos) {
                    //设置表单信息id  资监管项目时有此部分信息
                    String specialLenId = IdUtils.getSpecialLenId(20);
                    covertFormInfo.setFormInfoId(specialLenId);
                    //关联对应的办件信息
                    covertFormInfo.setBusISysInfoUuid(unid);
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
    }

    public void  setConvertBaseData(ConvertBaseData data, String operationLogo){
        System.out.println("数据"+data);
        if (operationLogo.equals("2")){
            data.setOperationLogo("2");
            data.setResourceInfoType("999");
        }else {
            data.setOperationLogo("1");
            data.setResourceInfoType("99");
        }
        wsspXmlMapper.insertConvertEntity(data);
    }
}

