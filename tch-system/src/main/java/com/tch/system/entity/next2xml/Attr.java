package com.tch.system.entity.next2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Attr {
    @XmlTransient
    private String nextAttrId;

    @XmlTransient
    private String dataId;

    @XmlElement(name = "AttrUNID")
    private String attrUNID;


    @XmlElement(name = "AttrSort")
    private String attrSort;


    @XmlElement(name = "AttrName")
    private String attrName;


    public String getNextAttrId() {
        return nextAttrId;
    }

    public void setNextAttrId(String nextAttrId) {
        this.nextAttrId = nextAttrId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

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
