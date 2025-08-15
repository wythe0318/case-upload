package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class SuppMatStart {
    @XmlTransient
    private String suppMatStartId;

    @XmlTransient
    private String dataId;


    @XmlElement(name = "SMSendUser")
    private String smSendUser;

    @XmlElement(name = "SMCause")
    private String smCause;

    @XmlElement(name = "SMSendTime")
    private String smSendTime;

    @XmlElementWrapper(name = "SuppMatStartAttrs")
    @XmlElement(name = "SuppMatStartAttr")
    private SuppMatStartAttr[] suppMatStartAttrs;


    public String getSuppMatStartId() {
        return suppMatStartId;
    }

    public void setSuppMatStartId(String suppMatStartId) {
        this.suppMatStartId = suppMatStartId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getSmSendUser() {
        return smSendUser;
    }

    public void setSmSendUser(String smSendUser) {
        this.smSendUser = smSendUser;
    }

    public String getSmCause() {
        return smCause;
    }

    public void setSmCause(String smCause) {
        this.smCause = smCause;
    }

    public String getSmSendTime() {
        return smSendTime;
    }

    public void setSmSendTime(String smSendTime) {
        this.smSendTime = smSendTime;
    }

    public SuppMatStartAttr[] getSuppMatStartAttrs() {
        return suppMatStartAttrs;
    }

    public void setSuppMatStartAttrs(SuppMatStartAttr[] suppMatStartAttrs) {
        this.suppMatStartAttrs = suppMatStartAttrs;
    }
}

