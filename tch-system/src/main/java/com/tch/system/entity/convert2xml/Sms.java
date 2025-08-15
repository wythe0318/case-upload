package com.tch.system.entity.convert2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author duanjunlong
 * @data 2024/3/21 19:11
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Sms {


    @XmlTransient
    private String smsId;


    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "SMSReceiver")
    private String smsReceiver;

    @XmlElement(name = "SMSAddress")
    private String smsAddress;

    @XmlElement(name = "SMSContent")
    private String smsContent;


    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getSmsReceiver() {
        return smsReceiver;
    }

    public void setSmsReceiver(String smsReceiver) {
        this.smsReceiver = smsReceiver;
    }

    public String getSmsAddress() {
        return smsAddress;
    }

    public void setSmsAddress(String smsAddress) {
        this.smsAddress = smsAddress;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }
}
