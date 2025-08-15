package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:41
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishResultAttr {
    @XmlTransient
    private String finishResultAttrId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "UNID")
    private String unid;

    @XmlElement(name = "AttrCategory")
    private String attrCategory;

    @XmlElement(name = "AttrName")
    private String attrName;

    @XmlElement(name = "AttrNumber")
    private String attrNumber;


    public String getFinishResultAttrId() {
        return finishResultAttrId;
    }

    public void setFinishResultAttrId(String finishResultAttrId) {
        this.finishResultAttrId = finishResultAttrId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getAttrCategory() {
        return attrCategory;
    }

    public void setAttrCategory(String attrCategory) {
        this.attrCategory = attrCategory;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrNumber() {
        return attrNumber;
    }

    public void setAttrNumber(String attrNumber) {
        this.attrNumber = attrNumber;
    }
}
