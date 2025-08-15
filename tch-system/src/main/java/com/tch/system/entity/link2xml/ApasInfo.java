package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ApasInfo {
    @XmlElement(name = "ProjectCode")
    private String projectCode;

    @XmlElement(name = "ApplyType")
    private String applyType;

    @XmlElement(name = "FromCode")
    private String fromCode;

    @XmlElement(name = "SwbMatterID")
    private String swbMatterID;

    @XmlElement(name = "SwbMatterName")
    private String swbMatterName;

    @XmlElement(name = "SrcMatterID")
    private String srcMatterID;

    @XmlElement(name = "AreaCode")
    private String areaCode;

    @XmlElement(name = "ProjectName")
    private String projectName;

    @XmlElement(name = "ReceiveDeptName")
    private String receiveDeptName;

    @XmlElement(name = "ReceiveDeptCode")
    private String receiveDeptCode;

    @XmlElement(name = "SwbSN")
    private String swbSN;

    @XmlElement(name = "SrcSN")
    private String srcSN;

    @XmlElement(name = "SeqNo")
    private String seqNo;

    @XmlElement(name = "Version")
    private String version;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public String getSwbMatterID() {
        return swbMatterID;
    }

    public void setSwbMatterID(String swbMatterID) {
        this.swbMatterID = swbMatterID;
    }

    public String getSwbMatterName() {
        return swbMatterName;
    }

    public void setSwbMatterName(String swbMatterName) {
        this.swbMatterName = swbMatterName;
    }

    public String getSrcMatterID() {
        return srcMatterID;
    }

    public void setSrcMatterID(String srcMatterID) {
        this.srcMatterID = srcMatterID;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getReceiveDeptName() {
        return receiveDeptName;
    }

    public void setReceiveDeptName(String receiveDeptName) {
        this.receiveDeptName = receiveDeptName;
    }

    public String getReceiveDeptCode() {
        return receiveDeptCode;
    }

    public void setReceiveDeptCode(String receiveDeptCode) {
        this.receiveDeptCode = receiveDeptCode;
    }

    public String getSwbSN() {
        return swbSN;
    }

    public void setSwbSN(String swbSN) {
        this.swbSN = swbSN;
    }

    public String getSrcSN() {
        return srcSN;
    }

    public void setSrcSN(String srcSN) {
        this.srcSN = srcSN;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
