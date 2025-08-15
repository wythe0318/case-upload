package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
class SuppMatEnd {
    @XmlElement(name = "SMAcceptUser")
    private String smAcceptUser;

    @XmlElement(name = "SMAcceptAddress")
    private String smAcceptAddress;

    @XmlElement(name = "SMAccpetTime")
    private String smAcceptTime;

    @XmlElementWrapper(name = "SuppMatEndAttrs")
    @XmlElement(name = "SuppMatEndAttr")
    private List<SuppMatEndAttr> suppMatEndAttrs;

    public String getSmAcceptUser() {
        return smAcceptUser;
    }

    public void setSmAcceptUser(String smAcceptUser) {
        this.smAcceptUser = smAcceptUser;
    }

    public String getSmAcceptAddress() {
        return smAcceptAddress;
    }

    public void setSmAcceptAddress(String smAcceptAddress) {
        this.smAcceptAddress = smAcceptAddress;
    }

    public String getSmAcceptTime() {
        return smAcceptTime;
    }

    public void setSmAcceptTime(String smAcceptTime) {
        this.smAcceptTime = smAcceptTime;
    }

    public List<SuppMatEndAttr> getSuppMatEndAttrs() {
        return suppMatEndAttrs;
    }

    public void setSuppMatEndAttrs(List<SuppMatEndAttr> suppMatEndAttrs) {
        this.suppMatEndAttrs = suppMatEndAttrs;
    }
}
