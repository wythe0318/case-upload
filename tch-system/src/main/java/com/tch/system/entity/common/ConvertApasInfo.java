package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/4/9 15:47
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ConvertApasInfo {

    @XmlElement(name = "ProjectCode")
    private String projectCode;

    @XmlElement(name = "FromCode")
    private String fromCode;


    @XmlElement(name = "SwbMatterID")
    private String swbMatterID;

    @XmlElement(name = "SwbMatterName")
    private String swbMatterName;


    @XmlElement(name = "SrcMatterID")
    private String srcMatterID;

    @XmlElement(name = "AreaCode")
    private String areaCode;

    @XmlElement(name = "ProjectName")
    private String projectName;

    @XmlElement(name = "Version")
    private int version;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public String getSwbMatterID() {
        return swbMatterID;
    }

    public void setSwbMatterID(String swbMatterID) {
        this.swbMatterID = swbMatterID;
    }

    public String getSwbMatterName() {
        return swbMatterName;
    }

    public void setSwbMatterName(String swbMatterName) {
        this.swbMatterName = swbMatterName;
    }

    public String getSrcMatterID() {
        return srcMatterID;
    }

    public void setSrcMatterID(String srcMatterID) {
        this.srcMatterID = srcMatterID;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
