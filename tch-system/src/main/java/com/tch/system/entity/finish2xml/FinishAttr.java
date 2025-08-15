package com.tch.system.entity.finish2xml;

import com.tch.system.entity.common.ConvertAttr;

import javax.xml.bind.annotation.*;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 10:17
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishAttr extends ConvertAttr {

    @XmlElement(name = "AttrName")
    private String attrName;

    @XmlElement(name = "Datashare")
    private String datashare;

    @XmlElement(name = "LicenseIdentifier")
    private String licenseIdentifier;

    @XmlElement(name = "CertificateTypeCode")
    private String certificateTypeCode;

    @XmlElement(name = "CertificateHolderCode")
    private String certificateHolderCode;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
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
