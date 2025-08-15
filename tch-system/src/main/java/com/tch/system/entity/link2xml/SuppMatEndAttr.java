package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
class SuppMatEndAttr {
    @XmlElement(name = "SuppMatEndAttrUNID")
    private String suppMatEndAttrUNID;

    @XmlElement(name = "AttrMode")
    private String attrMode;

    @XmlElement(name = "SuppMatEndAttrSwbCode")
    private String suppMatEndAttrSwbCode;

    @XmlElement(name = "SuppMatEndAttrSrcCode")
    private String suppMatEndAttrSrcCode;

    @XmlElement(name = "SuppMatEndAttrName")
    private String suppMatEndAttrName;

    @XmlElement(name = "SuppMatEndAttrSort")
    private String suppMatEndAttrSort;

    @XmlElement(name = "FileName")
    private String fileName;

    @XmlElement(name = "LicenseIdentifier")
    private String licenseIdentifier;

    @XmlElement(name = "CertificateTypeCode")
    private String certificateTypeCode;

    @XmlElement(name = "CertificateHolderCode")
    private String certificateHolderCode;

    public String getSuppMatEndAttrUNID() {
        return suppMatEndAttrUNID;
    }

    public void setSuppMatEndAttrUNID(String suppMatEndAttrUNID) {
        this.suppMatEndAttrUNID = suppMatEndAttrUNID;
    }

    public String getAttrMode() {
        return attrMode;
    }

    public void setAttrMode(String attrMode) {
        this.attrMode = attrMode;
    }

    public String getSuppMatEndAttrSwbCode() {
        return suppMatEndAttrSwbCode;
    }

    public void setSuppMatEndAttrSwbCode(String suppMatEndAttrSwbCode) {
        this.suppMatEndAttrSwbCode = suppMatEndAttrSwbCode;
    }

    public String getSuppMatEndAttrSrcCode() {
        return suppMatEndAttrSrcCode;
    }

    public void setSuppMatEndAttrSrcCode(String suppMatEndAttrSrcCode) {
        this.suppMatEndAttrSrcCode = suppMatEndAttrSrcCode;
    }

    public String getSuppMatEndAttrName() {
        return suppMatEndAttrName;
    }

    public void setSuppMatEndAttrName(String suppMatEndAttrName) {
        this.suppMatEndAttrName = suppMatEndAttrName;
    }

    public String getSuppMatEndAttrSort() {
        return suppMatEndAttrSort;
    }

    public void setSuppMatEndAttrSort(String suppMatEndAttrSort) {
        this.suppMatEndAttrSort = suppMatEndAttrSort;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLicenseIdentifier() {
        return licenseIdentifier;
    }

    public void setLicenseIdentifier(String licenseIdentifier) {
        this.licenseIdentifier = licenseIdentifier;
    }

    public String getCertificateTypeCode() {
        return certificateTypeCode;
    }

    public void setCertificateTypeCode(String certificateTypeCode) {
        this.certificateTypeCode = certificateTypeCode;
    }

    public String getCertificateHolderCode() {
        return certificateHolderCode;
    }

    public void setCertificateHolderCode(String certificateHolderCode) {
        this.certificateHolderCode = certificateHolderCode;
    }
}
