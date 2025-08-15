package com.tch.system.entity.wsspxml;

/**
 * @author duanjunlong
 * @data 2024/4/9 9:56
 */

import javax.xml.bind.annotation.XmlElement;

public class Sms {
    private String receiver;
    private String address;
    private String content;

    @XmlElement(name = "Receiver")
    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @XmlElement(name = "Address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement(name = "Content")
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
