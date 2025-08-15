package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialStart {
    @XmlTransient
    private  String specialStartId;

    @XmlTransient
    private  String dataId;

    @XmlElement(name = "ClassCode")
    private String classCode;

    @XmlElement(name = "ClassName")
    private String className;

    @XmlElement(name = "StartTime")
    private String startTime;

    @XmlElement(name = "ApproveUser")
    private String approveUser;

    @XmlElement(name = "ApproveUserTel")
    private String approveUserTel;

    @XmlElement(name = "ApproveUserMobi")
    private String approveUserMobi;

    @XmlElement(name = "Basis")
    private String basis;

    @XmlElement(name = "Content")
    private String content;

    @XmlElement(name = "Limit")
    private String limit;

    @XmlElement(name = "LimitUnit")
    private String limitUnit;

    @XmlElement(name = "PreEndTime")
    private String preEndTime;


    public String getSpecialStartId() {
        return specialStartId;
    }

    public void setSpecialStartId(String specialStartId) {
        this.specialStartId = specialStartId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }

    public String getApproveUserTel() {
        return approveUserTel;
    }

    public void setApproveUserTel(String approveUserTel) {
        this.approveUserTel = approveUserTel;
    }

    public String getApproveUserMobi() {
        return approveUserMobi;
    }

    public void setApproveUserMobi(String approveUserMobi) {
        this.approveUserMobi = approveUserMobi;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getLimitUnit() {
        return limitUnit;
    }

    public void setLimitUnit(String limitUnit) {
        this.limitUnit = limitUnit;
    }

    public String getPreEndTime() {
        return preEndTime;
    }

    public void setPreEndTime(String preEndTime) {
        this.preEndTime = preEndTime;
    }
}
