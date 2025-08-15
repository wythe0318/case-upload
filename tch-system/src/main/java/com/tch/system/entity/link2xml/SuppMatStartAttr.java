package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class SuppMatStartAttr {

    @XmlTransient
    private String suppMatStartAttrId;

    @XmlTransient
    private String dataId;

    @XmlElement(name = "SuppMatStartAttrSwbCode")
    private String suppMatStartAttrSwbCode;

    @XmlElement(name = "SuppMatStartAttrSrcCode")
    private String suppMatStartAttrSrcCode;

    @XmlElement(name = "SuppMatStartAttrName")
    private String suppMatStartAttrName;

    @XmlElement(name = "SuppMatStartAttrSeqNo")
    private String suppMatStartAttrSeqNo;

    public String getSuppMatStartAttrId() {
        return suppMatStartAttrId;
    }

    public void setSuppMatStartAttrId(String suppMatStartAttrId) {
        this.suppMatStartAttrId = suppMatStartAttrId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getSuppMatStartAttrSwbCode() {
        return suppMatStartAttrSwbCode;
    }

    public void setSuppMatStartAttrSwbCode(String suppMatStartAttrSwbCode) {
        this.suppMatStartAttrSwbCode = suppMatStartAttrSwbCode;
    }

    public String getSuppMatStartAttrSrcCode() {
        return suppMatStartAttrSrcCode;
    }

    public void setSuppMatStartAttrSrcCode(String suppMatStartAttrSrcCode) {
        this.suppMatStartAttrSrcCode = suppMatStartAttrSrcCode;
    }

    public String getSuppMatStartAttrName() {
        return suppMatStartAttrName;
    }

    public void setSuppMatStartAttrName(String suppMatStartAttrName) {
        this.suppMatStartAttrName = suppMatStartAttrName;
    }

    public String getSuppMatStartAttrSeqNo() {
        return suppMatStartAttrSeqNo;
    }

    public void setSuppMatStartAttrSeqNo(String suppMatStartAttrSeqNo) {
        this.suppMatStartAttrSeqNo = suppMatStartAttrSeqNo;
    }
}
