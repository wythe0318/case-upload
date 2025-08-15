package com.tch.system.entity.finish2xml;

import com.tch.system.entity.common.ConvertApasInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 10:12
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishApasInfo extends ConvertApasInfo {

    @XmlTransient
    private String finishApasInfoId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "ApplyType")
    private String applyType;

    @XmlElement(name = "ReceiveDeptName")
    private String receiveDeptName;

    @XmlElement(name = "ReceiveDeptCode")
    private String receiveDeptCode;

    @XmlElement(name = "SwbSN")
    private String swbSN;

    @XmlElement(name = "SrcSN")
    private String srcSN;


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

    @XmlElement(name = "isOpen")
    private String isOpen;

    @XmlElement(name = "IsExistLicence")
    private String isExistLicence;

    @XmlElement(name = "DeptCode")
    private String deptCode;

    @XmlElement(name = "DeptName")
    private String deptName;

    @XmlElement(name = "ResultType")
    private int resultType;

    @XmlElement(name = "ResultDesc")
    private String resultDesc;

    @XmlElement(name = "AbnCause")
    private String abnCause;

    @XmlElement(name = "TYSJM")
    private String tysjm;

    public String getTysjm() {
        return tysjm;
    }

    public void setTysjm(String tysjm) {
        this.tysjm = tysjm;
    }

    public String getFinishApasInfoId() {
        return finishApasInfoId;
    }

    public void setFinishApasInfoId(String finishApasInfoId) {
        this.finishApasInfoId = finishApasInfoId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
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

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getIsExistLicence() {
        return isExistLicence;
    }

    public void setIsExistLicence(String isExistLicence) {
        this.isExistLicence = isExistLicence;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getResultType() {
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getAbnCause() {
        return abnCause;
    }

    public void setAbnCause(String abnCause) {
        this.abnCause = abnCause;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }
}

