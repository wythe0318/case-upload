package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:44
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishLicenses {
    @XmlElement(name = "License")
    private FinishLicense[] license;

    public FinishLicense[] getLicense() {
        return license;
    }

    public void setLicense(FinishLicense[] license) {
        this.license = license;
    }
}
