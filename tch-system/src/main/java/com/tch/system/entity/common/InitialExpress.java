package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/4/10 17:20
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InitialExpress {

    @XmlElement(name = "Recipients")
    private String recipients;

    @XmlElement(name = "RCity")
    private String rCity;

    @XmlElement(name = "RAddress")
    private String rAddress;

    @XmlElement(name = "RAreaCode")
    private String rAreaCode;

    @XmlElement(name = "RMobile")
    private String rMobile;

    @XmlElement(name = "RContactNumber")
    private String rContactNumber;

    @XmlElement(name = "RPayType")
    private String rPayType;

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getrCity() {
        return rCity;
    }

    public void setrCity(String rCity) {
        this.rCity = rCity;
    }

    public String getrAddress() {
        return rAddress;
    }

    public void setrAddress(String rAddress) {
        this.rAddress = rAddress;
    }

    public String getrAreaCode() {
        return rAreaCode;
    }

    public void setrAreaCode(String rAreaCode) {
        this.rAreaCode = rAreaCode;
    }

    public String getrMobile() {
        return rMobile;
    }

    public void setrMobile(String rMobile) {
        this.rMobile = rMobile;
    }

    public String getrContactNumber() {
        return rContactNumber;
    }

    public void setrContactNumber(String rContactNumber) {
        this.rContactNumber = rContactNumber;
    }

    public String getrPayType() {
        return rPayType;
    }

    public void setrPayType(String rPayType) {
        this.rPayType = rPayType;
    }
}
