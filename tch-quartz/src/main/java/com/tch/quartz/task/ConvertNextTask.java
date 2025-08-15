package com.tch.quartz.task;

import com.tch.common.enums.DocumentsBase;
import com.tch.common.enums.ProcessStatus;
import com.tch.common.enums.TypeConversion;
import com.tch.common.utils.DateUtils;
import com.tch.common.utils.StringUtils;
import com.tch.common.utils.bean.BeanUtils;
import com.tch.system.constants.Constants;
import com.tch.system.domain.YthTGaShlbjxxInfo;
import com.tch.system.entity.common.CovertDocument;
import com.tch.system.entity.common.CovertDocuments;
import com.tch.system.entity.common.Router;
import com.tch.system.entity.convert2xml.ConvertBody;
import com.tch.system.entity.convert2xml.ConvertEntity;
import com.tch.system.entity.convert2xml.ConvertEntityApasInfo;
import com.tch.system.entity.next2xml.*;
import com.tch.system.entity.nextxml.NextBean;
import com.tch.system.mapper.NextXmlMapper;
import com.tch.system.mapper.WsspXmlMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.tch.system.util.CaseXmlConverter.convertToXml;

/**
 * @author duanjunlong
 * @data 2024/3/21 14:39
 */
@Component
public class ConvertNextTask {

    @Resource
    private NextXmlMapper nextXmlMapper;

    @Resource
    private WsspXmlMapper wsspXmlMapper;


    public static ConvertNextTask convertNextTask;

    @PostConstruct
    public void init() {
        convertNextTask = this;
        convertNextTask.wsspXmlMapper = this.wsspXmlMapper;
        convertNextTask.nextXmlMapper = this.nextXmlMapper;
    }


    //生成审批过程xml
    public static String createNextData(NextBean nextCaseEntity, ConvertEntity convertEntity, YthTGaShlbjxxInfo businessBean, String nextUuid, String preUnid, Logger logger) {
        ConvertBody convertBody = convertEntity.getBody();
        NextCaseEntity caseObj = new NextCaseEntity();
        caseObj.setApplyFrom(DocumentsBase.checkKeyExists(nextCaseEntity.getApplyFrom()));
        caseObj.setType(TypeConversion.checkKeyExists(nextCaseEntity.getType()));
        caseObj.setUnid(nextUuid);
        caseObj.setXsd(nextCaseEntity.getXsd());


        //路由信息
        Router router = new Router();
        router.setFromAreaCode(Constants.FromAreaCode);//厦门公安政务服务平台系统代码
        router.setFromAreaName(Constants.FromAreaName);
        router.setToAreaCode(Constants.ToAreaCode);
        router.setToAreaName(Constants.ToAreaName);
        router.setTargetSystem(Constants.ToAreaCode);
        //生成xml的当前时间
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        router.setSendTime(date);
        router.setPrevLinkUNID(preUnid);
        caseObj.setRouter(router);


        //数据区
        NextBody body = new NextBody();
        //ApasInfo标签

        NextConvertApasInfo apasInfo = new NextConvertApasInfo();
        ConvertEntityApasInfo convertApasInfo = convertBody.getApasInfo();
        apasInfo.setProjectCode(convertApasInfo.getProjectCode());//投资项目编码 非必填项
        apasInfo.setApplyType(convertBody.getProposer().getApplyType());//申报种类
        apasInfo.setFromCode(Constants.FromAreaCode);
        apasInfo.setProjectName(convertApasInfo.getProjectName());//申报名称
        apasInfo.setSwbMatterName(convertApasInfo.getSwbMatterName());
        apasInfo.setSwbMatterID(convertApasInfo.getSwbMatterID());//省网上办事大厅的审批事项编码
        apasInfo.setSrcMatterID(convertApasInfo.getSrcMatterID());
        apasInfo.setAreaCode(convertApasInfo.getAreaCode());
        apasInfo.setReceiveDeptName(convertApasInfo.getReceiveDeptName());
        apasInfo.setReceiveDeptCode(convertApasInfo.getReceiveDeptCode());
        apasInfo.setSwbSN(nextCaseEntity.getNextBody().getNextApasInfo().getSN());//省网办申报号
        apasInfo.setSrcSN(nextCaseEntity.getNextBody().getNextApasInfo().getSN());//原系统申报号
        apasInfo.setSeqNo(nextCaseEntity.getNextBody().getNextNode().getCode());//环节序号
        apasInfo.setVersion(1);//数据版本号
        body.setApasInfo(apasInfo);


        //办件过程信息
        NextNode node = new NextNode();

        com.tch.system.entity.nextxml.NextNode nextNode = nextCaseEntity.getNextBody().getNextNode();
        String isSpecial = nextNode.getIsSpecial();
        //判断 该业务是否是特殊处理
        if (StringUtils.isNotEmpty(isSpecial) && isSpecial.equals("1")) {
            node.setIsSpecial(isSpecial);
            node.setNodeGuid("");//当isSpecial=1时【必填】，补交开始与补交结束保持一致，特殊环节开始与特殊环节结束保持一致，建议采用复杂标识，报送到省网后避免与其他系统混淆
        } else {
            node.setIsSpecial("0");//正常环节=0
            node.setNodeGuid("");
        }

        node.setSwbCode(nextNode.getCode());
        node.setSwbName(nextNode.getName());
        node.setDzjcCode("");
        node.setDzjcName("");
        node.setSrcName(nextNode.getName());
        if (nextNode.getCode().equals("2") || nextNode.getCode().equals("4")) {
            //当code=2（受理）/4（办结）时允许为空
            if (StringUtils.isNotEmpty(nextNode.getNextName())) {
                node.setNextName(ProcessStatus.checkKeyExists(nextNode.getNextName()));
            } else {
                node.setNextName("");
            }
            //下一环节办理人
            if (StringUtils.isNotEmpty(nextNode.getNextUser())) {
                node.setNextUser(nextNode.getNextUser());
            } else {
                node.setNextUser("");
            }
        } else {
            node.setNextName(ProcessStatus.checkKeyExists(nextNode.getNextName()));
            node.setNextUser(nextNode.getNextUser());
        }


        Attr[] nextNodeAttrs = nextNode.getAttrs();
        if (nextNodeAttrs.length > 0) {
            Attrs attrs = new Attrs();
            attrs.setAttrList(nextNodeAttrs);
            for (Attr nextNodeAttr : nextNodeAttrs) {
                nextNodeAttr.setDataId(nextUuid);
                convertNextTask.nextXmlMapper.insertNextAttr(nextNodeAttr);
            }
            node.setAttrs(attrs);
        }



        node.setProcessedUser(nextNode.getProcessedUser());
        node.setProcessedOpinion("");//办理人职务
        node.setProcessedUserPtCode("");//办理人职务代码
        node.setProcessedUserCode("");//办理人职务代码
        node.setStartTime(nextNode.getStartTime());
        node.setProcessedTime(nextNode.getModified());
        node.setType(nextNode.getType());
        node.setProcessedOpinion(nextNode.getProcessedOpinion());
        String promiseEndTime = nextNode.getPromiseEndTime();
        //进行判断 属性不能为空 如果是yyyy-MM-dd HH:mm:ss格式的直接进行转换
        if (StringUtils.isNotEmpty(promiseEndTime) && promiseEndTime.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parse = inputFormat.parse(promiseEndTime);
                String convertPromiseEndTime = DateUtils.dateTime(parse);
                node.setPromiseEndTime(convertPromiseEndTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (promiseEndTime.matches("\\d{4}-\\d{2}-\\d{2}")) {  //不是判断是否是yyyy-MM-dd格式
            node.setPromiseEndTime(promiseEndTime);
        }

        String conversion = AcceptanceConversion(nextNode.getName());
        node.setIsAcpt(conversion);
        //当进行不受理的时
        if (StringUtils.isNotEmpty(conversion) && conversion.equals("0")) {
            node.setNoAcptCause(nextNode.getNoAcptCause());
        } else {
            node.setNoAcptCause("");
        }

        node.setOtherInfo("");//电子监察系统的环节为“送达”环节时，填写送达方式；为“文书制作”环节时，填写文书名称。其他环节留空
        if (StringUtils.isNotEmpty(nextNode.getRemark())) {
            node.setRemark(nextNode.getRemark());

        } else {
            node.setRemark("");
        }
        body.setNode(node);



        CovertDocuments nextDocumentData = new CovertDocuments();
        if (nextCaseEntity.getNextBody().getNextNode().getDocuments() != null && nextCaseEntity.getNextBody().getNextNode().getDocuments().getDocument() != null
                && nextCaseEntity.getNextBody().getNextNode().getDocuments().getDocument().length > 0) {
            CovertDocument[] document = nextDocumentData.getCovertDocument();
            BeanUtils.copyBeanProp(nextCaseEntity.getNextBody().getNextNode().getDocuments(), nextDocumentData);
            nextDocumentData.setCovertDocument(document);

            for (CovertDocument nextDocument : document) {
                nextDocument.setDataId(nextUuid);
                convertNextTask.wsspXmlMapper.insertDocument(nextDocument);
            }
        }


        //查询共享平台推送到业务系统的数据表 是否是特殊环节的数据
        //计时暂停和计时回复不为空就是特殊环节 和 补件环节
        if (ObjectUtils.isNotEmpty(businessBean.getSuspendXml()) && ObjectUtils.isNotEmpty(businessBean.getResumeXml())) {
           //目前不涉及补件
        }
        node.setDocuments(nextDocumentData);
        body.setNode(node);
        caseObj.setBody(body);
        String xmlString = convertToXml(caseObj);
        xmlString = xmlString.replace(" standalone=\"yes\"", "");

        insertNextData(nextUuid, caseObj, router, apasInfo, node);

        logger.info("审批结果信息xml:" + xmlString);
        return xmlString;

    }

    private static void insertNextData(String nextUuid, NextCaseEntity caseObj, Router router, NextConvertApasInfo apasInfo, NextNode node) {
        convertNextTask.wsspXmlMapper.insertConvertEntity(caseObj);
        router.setDataId(nextUuid);
        convertNextTask.wsspXmlMapper.insertRouter(router);
        apasInfo.setBusISysInfoUuid(nextUuid);
        convertNextTask.nextXmlMapper.insertNextApasInfo(apasInfo);
        node.setBusISysInfoUuid(nextUuid);
        convertNextTask.nextXmlMapper.insertNextNode(node);
    }

    /**
     * 结果编码转换
     *
     * @param s
     * @return
     */
    public static String AcceptanceConversion(String s) {
        if (s.equals("受理")) {
            return "1";
        } else {
            return "0";
        }
    }
}
