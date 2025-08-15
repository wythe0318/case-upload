package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Attr {
    @XmlElement(name = "AttrUNID")
    private String attrUNID;

    @XmlElement(name = "AttrSort")
    private String attrSort;

    @XmlElement(name = "AttrName")
    private String attrName;

    public String getAttrUNID() {
        return attrUNID;
    }

    public void setAttrUNID(String attrUNID) {
        this.attrUNID = attrUNID;
    }

    public String getAttrSort() {
        return attrSort;
    }

    public void setAttrSort(String attrSort) {
        this.attrSort = attrSort;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
}
