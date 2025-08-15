package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:32
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishApasInfo {
    @XmlElement(name = "SN")
    private String sn;

    @XmlElement(name = "ProcessedUser")
    private String processedUser;

    @XmlElement(name = "ProcessedTime")
    private String processedTime;

    @XmlElement(name = "Result")
    private String result;

    @XmlElement(name = "DeliveryResult")
    private String deliveryResult;

    @XmlElement(name = "ProcessedOpinion")
    private String processedOpinion;

    @XmlElement(name = "OpenWay")
    private String openWay;

    @XmlElement(name = "MakePublic")
    private String makePublic;

    @XmlElement(name = "IsExistLicence")
    private String isExistLicence;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getProcessedUser() {
        return processedUser;
    }

    public void setProcessedUser(String processedUser) {
        this.processedUser = processedUser;
    }

    public String getProcessedTime() {
        return processedTime;
    }

    public void setProcessedTime(String processedTime) {
        this.processedTime = processedTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDeliveryResult() {
        return deliveryResult;
    }

    public void setDeliveryResult(String deliveryResult) {
        this.deliveryResult = deliveryResult;
    }

    public String getProcessedOpinion() {
        return processedOpinion;
    }

    public void setProcessedOpinion(String processedOpinion) {
        this.processedOpinion = processedOpinion;
    }

    public String getOpenWay() {
        return openWay;
    }

    public void setOpenWay(String openWay) {
        this.openWay = openWay;
    }

    public String getMakePublic() {
        return makePublic;
    }

    public void setMakePublic(String makePublic) {
        this.makePublic = makePublic;
    }

    public String getIsExistLicence() {
        return isExistLicence;
    }

    public void setIsExistLicence(String isExistLicence) {
        this.isExistLicence = isExistLicence;
    }
}
