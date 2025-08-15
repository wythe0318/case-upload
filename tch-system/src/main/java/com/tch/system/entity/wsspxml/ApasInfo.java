package com.tch.system.entity.wsspxml;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ApasInfo {
    @XmlElement(name = "ServiceID")
    private String serviceID;

    @XmlElement(name = "ServiceCode")
    private String serviceCode;

    @XmlElement(name = "ServiceName")
    private String serviceName;

    @XmlElement(name = "AreaCode")
    private String areaCode;

    @XmlElement(name = "ProjectCode")
    private String projectCode;

    @XmlElement(name = "ProjectName")
    private String projectName;

    @XmlElement(name = "SN")
    private String sn;

    @XmlElement(name = "PWD")
    private String pwd;

    @XmlElement(name = "PromiseDay")
    private int promiseDay;

    @XmlElement(name = "DeclareTime")
    private String declareTime;

    @XmlElement(name = "ReceiveDeptName")
    private String receiveDeptName;

    @XmlElement(name = "ReceiveDeptCode")
    private String receiveDeptCode;

    @XmlElement(name = "OpenWay")
    private String openWay;

    @XmlElement(name = "CentralApprovalItemid")
    private String centralApprovalItemid;

    @XmlElement(name = "RelItemFlag")
    private String relItemFlag;

    @XmlElement(name = "RelDeptCode")
    private String relDeptCode;

    @XmlElement(name = "RelCentralItemCode")
    private String relCentralItemCode;

    @XmlElement(name = "ClassUnid")
    private String classUnid;

    @XmlElement(name = "ClassName")
    private String className;

    @XmlElement(name = "TYSJM")
    private String tysjm;

    public String getTysjm() {
        return tysjm;
    }

    public void setTysjm(String tysjm) {
        this.tysjm = tysjm;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getPromiseDay() {
        return promiseDay;
    }

    public void setPromiseDay(int promiseDay) {
        this.promiseDay = promiseDay;
    }

    public String getDeclareTime() {
        return declareTime;
    }

    public void setDeclareTime(String declareTime) {
        this.declareTime = declareTime;
    }

    public String getReceiveDeptName() {
        return receiveDeptName;
    }

    public void setReceiveDeptName(String receiveDeptName) {
        this.receiveDeptName = receiveDeptName;
    }

    public String getReceiveDeptCode() {
        return receiveDeptCode;
    }

    public void setReceiveDeptCode(String receiveDeptCode) {
        this.receiveDeptCode = receiveDeptCode;
    }

    public String getOpenWay() {
        return openWay;
    }

    public void setOpenWay(String openWay) {
        this.openWay = openWay;
    }

    public String getCentralApprovalItemid() {
        return centralApprovalItemid;
    }

    public void setCentralApprovalItemid(String centralApprovalItemid) {
        this.centralApprovalItemid = centralApprovalItemid;
    }

    public String getRelItemFlag() {
        return relItemFlag;
    }

    public void setRelItemFlag(String relItemFlag) {
        this.relItemFlag = relItemFlag;
    }

    public String getRelDeptCode() {
        return relDeptCode;
    }

    public void setRelDeptCode(String relDeptCode) {
        this.relDeptCode = relDeptCode;
    }

    public String getRelCentralItemCode() {
        return relCentralItemCode;
    }

    public void setRelCentralItemCode(String relCentralItemCode) {
        this.relCentralItemCode = relCentralItemCode;
    }

    public String getClassUnid() {
        return classUnid;
    }

    public void setClassUnid(String classUnid) {
        this.classUnid = classUnid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
