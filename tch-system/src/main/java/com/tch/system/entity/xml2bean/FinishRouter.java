package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:27
 */
@XmlAccessorType(XmlAccessType.FIELD)
class FinishRouter {
    @XmlElement(name = "FromAreaCode")
    private String fromAreaCode;

    @XmlElement(name = "FromAreaName")
    private String fromAreaName;

    @XmlElement(name = "ToAreaCode")
    private String toAreaCode;

    @XmlElement(name = "ToAreaName")
    private String toAreaName;

    @XmlElement(name = "Time")
    private String time;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
