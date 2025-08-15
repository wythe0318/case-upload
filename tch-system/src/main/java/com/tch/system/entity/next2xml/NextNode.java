package com.tch.system.entity.next2xml;

import com.tch.system.entity.common.CovertDocuments;

import com.tch.system.entity.link2xml.Special;
import com.tch.system.entity.link2xml.SuppMat;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class NextNode {
    @XmlTransient
    private String nextNodeId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "isSpecial")
    private String isSpecial;

    @XmlElement(name = "NodeGuid")
    private String nodeGuid;

    @XmlElement(name = "SwbCode")
    private String swbCode;

    @XmlElement(name = "SwbName")
    private String swbName;

    @XmlElement(name = "DzjcCode")
    private String dzjcCode;

    @XmlElement(name = "DzjcName")
    private String dzjcName;

    @XmlElement(name = "SrcName")
    private String srcName;

    @XmlElement(name = "NextName")
    private String nextName;

    @XmlElement(name = "NextUser")
    private String nextUser;

    @XmlElement(name = "ProcessedUser")
    private String processedUser;

    @XmlElement(name = "ProcessedUserPosition")
    private String processedUserPosition;

    @XmlElement(name = "ProcessedUserPtCode")
    private String processedUserPtCode;

    @XmlElement(name = "ProcessedUserCode")
    private String processedUserCode;

    @XmlElement(name = "StartTime")
    private String startTime;

    @XmlElement(name = "ProcessedTime")
    private String processedTime;

    @XmlElement(name = "Type")
    private String type;

    @XmlElement(name = "ProcessedOpinion")
    private String processedOpinion;

    @XmlElement(name = "PromiseEndTime")
    private String promiseEndTime;

    @XmlElement(name = "isAcpt")
    private String isAcpt;

    @XmlElement(name = "NoAcptCause")
    private String noAcptCause;

    @XmlElement(name = "OtherInfo")
    private String otherInfo;

    @XmlElement(name = "Remark")
    private String remark;

//    @XmlElementWrapper(name = "Attrs")
    @XmlElement(name = "Attrs")
    private Attrs attrs;

//    @XmlElementWrapper(name = "Documents")
    @XmlElement(name = "Document")
    private CovertDocuments documents;

    @XmlElement(name = "SuppMat")
    private SuppMat suppMat;

    @XmlElement(name = "Special")
    private Special special;


    public String getNextNodeId() {
        return nextNodeId;
    }

    public void setNextNodeId(String nextNodeId) {
        this.nextNodeId = nextNodeId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getNodeGuid() {
        return nodeGuid;
    }

    public void setNodeGuid(String nodeGuid) {
        this.nodeGuid = nodeGuid;
    }

    public String getSwbCode() {
        return swbCode;
    }

    public void setSwbCode(String swbCode) {
        this.swbCode = swbCode;
    }

    public String getSwbName() {
        return swbName;
    }

    public void setSwbName(String swbName) {
        this.swbName = swbName;
    }

    public String getDzjcCode() {
        return dzjcCode;
    }

    public void setDzjcCode(String dzjcCode) {
        this.dzjcCode = dzjcCode;
    }

    public String getDzjcName() {
        return dzjcName;
    }

    public void setDzjcName(String dzjcName) {
        this.dzjcName = dzjcName;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public String getNextName() {
        return nextName;
    }

    public void setNextName(String nextName) {
        this.nextName = nextName;
    }

    public String getNextUser() {
        return nextUser;
    }

    public void setNextUser(String nextUser) {
        this.nextUser = nextUser;
    }

    public String getProcessedUser() {
        return processedUser;
    }

    public void setProcessedUser(String processedUser) {
        this.processedUser = processedUser;
    }

    public String getProcessedUserPosition() {
        return processedUserPosition;
    }

    public void setProcessedUserPosition(String processedUserPosition) {
        this.processedUserPosition = processedUserPosition;
    }

    public String getProcessedUserPtCode() {
        return processedUserPtCode;
    }

    public void setProcessedUserPtCode(String processedUserPtCode) {
        this.processedUserPtCode = processedUserPtCode;
    }

    public String getProcessedUserCode() {
        return processedUserCode;
    }

    public void setProcessedUserCode(String processedUserCode) {
        this.processedUserCode = processedUserCode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getProcessedTime() {
        return processedTime;
    }

    public void setProcessedTime(String processedTime) {
        this.processedTime = processedTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProcessedOpinion() {
        return processedOpinion;
    }

    public void setProcessedOpinion(String processedOpinion) {
        this.processedOpinion = processedOpinion;
    }

    public String getPromiseEndTime() {
        return promiseEndTime;
    }

    public void setPromiseEndTime(String promiseEndTime) {
        this.promiseEndTime = promiseEndTime;
    }

    public String getIsAcpt() {
        return isAcpt;
    }

    public void setIsAcpt(String isAcpt) {
        this.isAcpt = isAcpt;
    }

    public String getNoAcptCause() {
        return noAcptCause;
    }

    public void setNoAcptCause(String noAcptCause) {
        this.noAcptCause = noAcptCause;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Attrs getAttrs() {
        return attrs;
    }

    public void setAttrs(Attrs attrs) {
        this.attrs = attrs;
    }

    public CovertDocuments getDocuments() {
        return documents;
    }

    public void setDocuments(CovertDocuments documents) {
        this.documents = documents;
    }

    public SuppMat getSuppMat() {
        return suppMat;
    }

    public void setSuppMat(SuppMat suppMat) {
        this.suppMat = suppMat;
    }

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }
}

