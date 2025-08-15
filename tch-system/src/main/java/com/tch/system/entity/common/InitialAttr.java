package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/4/10 16:42
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InitialAttr {

    @XmlElement(name = "UNID")
    private String unid;

    @XmlElement(name = "Mode")
    private String mode;

    @XmlElement(name = "Code")
    private String code;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "SeqNo")
    private String seqNo;

    @XmlElement(name = "FileName")
    private String fileName;

    @XmlElement(name = "Datashare")
    private String datashare;

    @XmlElement(name = "LicenseIdentifier")
    private String licenseIdentifier;

    @XmlElement(name = "CertificateTypeCode")
    private String certificateTypeCode;

    @XmlElement(name = "CertificateHolderCode")
    private String certificateHolderCode;

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDatashare() {
        return datashare;
    }

    public void setDatashare(String datashare) {
        this.datashare = datashare;
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
