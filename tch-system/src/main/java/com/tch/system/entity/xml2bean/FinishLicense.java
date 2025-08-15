package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:44
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishLicense {
    @XmlTransient
    private String finishLicenseId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "DocType")
    private String docType;

    @XmlElement(name = "SeqNo")
    private String seqNo;

    @XmlElement(name = "LicenseName")
    private String licenseName;

    @XmlElement(name = "StartDate")
    private String startDate;

    @XmlElement(name = "ValidateDate")
    private String validateDate;

    @XmlElement(name = "CertUnit")
    private String certUnit;

    @XmlElement(name = "CertUnitCode")
    private String certUnitCode;

    @XmlElement(name = "CertContent")
    private String certContent;

    @XmlElement(name = "CertifiedTime")
    private String certifiedTime;

    @XmlElement(name = "Holder")
    private String holder;

    @XmlElement(name = "CertificateHolderCode")
    private String certificateHolderCode;


    public String getFinishLicenseId() {
        return finishLicenseId;
    }

    public void setFinishLicenseId(String finishLicenseId) {
        this.finishLicenseId = finishLicenseId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getLicenseName() {
        return licenseName;
    }

    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(String validateDate) {
        this.validateDate = validateDate;
    }

    public String getCertUnit() {
        return certUnit;
    }

    public void setCertUnit(String certUnit) {
        this.certUnit = certUnit;
    }

    public String getCertUnitCode() {
        return certUnitCode;
    }

    public void setCertUnitCode(String certUnitCode) {
        this.certUnitCode = certUnitCode;
    }

    public String getCertContent() {
        return certContent;
    }

    public void setCertContent(String certContent) {
        this.certContent = certContent;
    }

    public String getCertifiedTime() {
        return certifiedTime;
    }

    public void setCertifiedTime(String certifiedTime) {
        this.certifiedTime = certifiedTime;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getCertificateHolderCode() {
        return certificateHolderCode;
    }

    public void setCertificateHolderCode(String certificateHolderCode) {
        this.certificateHolderCode = certificateHolderCode;
    }
}
