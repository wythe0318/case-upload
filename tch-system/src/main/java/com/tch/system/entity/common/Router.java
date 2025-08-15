package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Router {

    @XmlTransient
    private String routerId;

    @XmlTransient
    private String dataId;


    @XmlElement(name = "FromAreaCode")
    private String fromAreaCode;

    @XmlElement(name = "FromAreaName")
    private String fromAreaName;

    @XmlElement(name = "ToAreaCode")
    private String toAreaCode;

    @XmlElement(name = "ToAreaName")
    private String toAreaName;

    @XmlElement(name = "TargetSystem")
    private String targetSystem;

    @XmlElement(name = "SendTime")
    private String sendTime;

    @XmlElement(name = "PrevLinkUNID")
    private String prevLinkUNID;

    public String getRouterId() {
        return routerId;
    }

    public void setRouterId(String routerId) {
        this.routerId = routerId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getFromAreaCode() {
        return fromAreaCode;
    }

    public void setFromAreaCode(String fromAreaCode) {
        this.fromAreaCode = fromAreaCode;
    }

    public String getFromAreaName() {
        return fromAreaName;
    }

    public void setFromAreaName(String fromAreaName) {
        this.fromAreaName = fromAreaName;
    }

    public String getToAreaCode() {
        return toAreaCode;
    }

    public void setToAreaCode(String toAreaCode) {
        this.toAreaCode = toAreaCode;
    }

    public String getToAreaName() {
        return toAreaName;
    }

    public void setToAreaName(String toAreaName) {
        this.toAreaName = toAreaName;
    }

    public String getTargetSystem() {
        return targetSystem;
    }

    public void setTargetSystem(String targetSystem) {
        this.targetSystem = targetSystem;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getPrevLinkUNID() {
        return prevLinkUNID;
    }

    public void setPrevLinkUNID(String prevLinkUNID) {
        this.prevLinkUNID = prevLinkUNID;
    }
}
