package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author duanjunlong
 * @data 2024/4/10 16:19
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ConvertAttr {
    @XmlTransient
    private String attrId;

    @XmlTransient
    private String dataId;

    @XmlElement(name = "AttrUNID")
    private String attrUNID;

    @XmlElement(name = "AttrMode")
    private String attrMode;

    @XmlElement(name = "SwbCode")
    private String swbCode;

    @XmlElement(name = "SrcCode")
    private String srcCode;

    @XmlElement(name = "Sort")
    private String sort;

    @XmlElement(name = "FileName")
    private String fileName;


    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
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

    public String getAttrMode() {
        return attrMode;
    }

    public void setAttrMode(String attrMode) {
        this.attrMode = attrMode;
    }

    public String getSwbCode() {
        return swbCode;
    }

    public void setSwbCode(String swbCode) {
        this.swbCode = swbCode;
    }

    public String getSrcCode() {
        return srcCode;
    }

    public void setSrcCode(String srcCode) {
        this.srcCode = srcCode;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
