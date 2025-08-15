package com.tch.system.entity.convert2xml;

import com.tch.system.entity.common.ConvertAttr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Attr extends ConvertAttr {
    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Datashare")
    private String datashare;

    @XmlElement(name = "LicenseIdentifier")
    private String licenseIdentifier;

    @XmlElement(name = "CertificateTypeCode")
    private String certificateTypeCode;

    @XmlElement(name = "CertificateHolderCode")
    private String certificateHolderCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
