package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialEnd {
    @XmlTransient
    private  String specialEndId;

    @XmlTransient
    private  String dataId;
    @XmlElement(name = "OperUser")
    private String operUser;

    @XmlElement(name = "Result")
    private String result;

    @XmlElement(name = "ResultTime")
    private String resultTime;

    @XmlElement(name = "EndTime")
    private String endTime;

    @XmlElement(name = "SpecialEndChargeAmount")
    private String specialEndChargeAmount;

    public String getSpecialEndId() {
        return specialEndId;
    }

    public void setSpecialEndId(String specialEndId) {
        this.specialEndId = specialEndId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultTime() {
        return resultTime;
    }

    public void setResultTime(String resultTime) {
        this.resultTime = resultTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSpecialEndChargeAmount() {
        return specialEndChargeAmount;
    }

    public void setSpecialEndChargeAmount(String specialEndChargeAmount) {
        this.specialEndChargeAmount = specialEndChargeAmount;
    }
}
