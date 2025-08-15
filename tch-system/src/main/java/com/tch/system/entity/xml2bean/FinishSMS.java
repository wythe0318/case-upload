package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:42
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishSMS {
    @XmlTransient
    private String finishSmsId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "Receiver")
    private String receiver;

    @XmlElement(name = "Address")
    private String address;

    @XmlElement(name = "Content")
    private String content;

    public String getFinishSmsId() {
        return finishSmsId;
    }

    public void setFinishSmsId(String finishSmsId) {
        this.finishSmsId = finishSmsId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
