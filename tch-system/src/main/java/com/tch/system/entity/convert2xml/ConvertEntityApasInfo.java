package com.tch.system.entity.convert2xml;

import com.tch.system.entity.common.ConvertApasInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class ConvertEntityApasInfo extends ConvertApasInfo {
    @XmlTransient
    private String ApasInfoId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "SwbServiceType")
    private String swbServiceType;

    @XmlElement(name = "SwbMatteType")
    private String swbMatteType;

    @XmlElement(name = "SwbServiceID")
    private String swbServiceID;


    @XmlElement(name = "PromiseDay")
    private int promiseDay;

    @XmlElement(name = "PromiseDayUnit")
    private String promiseDayUnit;

    @XmlElement(name = "SwbSN")
    private String swbSN;

    @XmlElement(name = "SrcSN")
    private String srcSN;

    @XmlElement(name = "PWD")
    private String pwd;

    @XmlElement(name = "DeclareTime")
    private String declareTime;

    @XmlElement(name = "ReceiveDeptName")
    private String receiveDeptName;

    @XmlElement(name = "ReceiveDeptCode")
    private String receiveDeptCode;

    @XmlElement(name = "AcceptAddress")
    private String acceptAddress;

    @XmlElement(name = "SubWay")
    private int subWay;

    @XmlElement(name = "QueuingNo")
    private String queuingNo;

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

    public String getSwbServiceType() {
        return swbServiceType;
    }

    public void setSwbServiceType(String swbServiceType) {
        this.swbServiceType = swbServiceType;
    }

    public String getSwbMatteType() {
        return swbMatteType;
    }

    public void setSwbMatteType(String swbMatteType) {
        this.swbMatteType = swbMatteType;
    }

    public String getApasInfoId() {
        return ApasInfoId;
    }

    public void setApasInfoId(String apasInfoId) {
        ApasInfoId = apasInfoId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getSwbServiceID() {
        return swbServiceID;
    }

    public void setSwbServiceID(String swbServiceID) {
        this.swbServiceID = swbServiceID;
    }

    public int getPromiseDay() {
        return promiseDay;
    }

    public void setPromiseDay(int promiseDay) {
        this.promiseDay = promiseDay;
    }

    public String getPromiseDayUnit() {
        return promiseDayUnit;
    }

    public void setPromiseDayUnit(String promiseDayUnit) {
        this.promiseDayUnit = promiseDayUnit;
    }

    public String getSwbSN() {
        return swbSN;
    }

    public void setSwbSN(String swbSN) {
        this.swbSN = swbSN;
    }

    public String getSrcSN() {
        return srcSN;
    }

    public void setSrcSN(String srcSN) {
        this.srcSN = srcSN;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public String getAcceptAddress() {
        return acceptAddress;
    }

    public void setAcceptAddress(String acceptAddress) {
        this.acceptAddress = acceptAddress;
    }

    public int getSubWay() {
        return subWay;
    }

    public void setSubWay(int subWay) {
        this.subWay = subWay;
    }

    public String getQueuingNo() {
        return queuingNo;
    }

    public void setQueuingNo(String queuingNo) {
        this.queuingNo = queuingNo;
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
