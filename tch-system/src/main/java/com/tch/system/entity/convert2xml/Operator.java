package com.tch.system.entity.convert2xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Operator {

    @XmlTransient
    private String operatorId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "OperatorApplyName")
    private String operatorApplyName;

    @XmlElement(name = "OperatorSex")
    private String operatorSex;

    @XmlElement(name = "OperatorBirthday")
    private String operatorBirthday;

    @XmlElement(name = "OperatorCertificateType")
    private String operatorCertificateType;

    @XmlElement(name = "OperatorCertificateName")
    private String operatorCertificateName;

    @XmlElement(name = "OperatorCertificateNumber")
    private String operatorCertificateNumber;

    @XmlElement(name = "OperatorAddress")
    private String operatorAddress;

    @XmlElement(name = "OperatorPostcode")
    private String operatorPostcode;

    @XmlElement(name = "OperatorMobilePhone")
    private String operatorMobilePhone;

    @XmlElement(name = "OperatorMail")
    private String operatorMail;

    @XmlElement(name = "OperatorTel")
    private String operatorTel;


    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getOperatorApplyName() {
        return operatorApplyName;
    }

    public void setOperatorApplyName(String operatorApplyName) {
        this.operatorApplyName = operatorApplyName;
    }

    public String getOperatorSex() {
        return operatorSex;
    }

    public void setOperatorSex(String operatorSex) {
        this.operatorSex = operatorSex;
    }

    public String getOperatorBirthday() {
        return operatorBirthday;
    }

    public void setOperatorBirthday(String operatorBirthday) {
        this.operatorBirthday = operatorBirthday;
    }

    public String getOperatorCertificateType() {
        return operatorCertificateType;
    }

    public void setOperatorCertificateType(String operatorCertificateType) {
        this.operatorCertificateType = operatorCertificateType;
    }

    public String getOperatorCertificateName() {
        return operatorCertificateName;
    }

    public void setOperatorCertificateName(String operatorCertificateName) {
        this.operatorCertificateName = operatorCertificateName;
    }

    public String getOperatorCertificateNumber() {
        return operatorCertificateNumber;
    }

    public void setOperatorCertificateNumber(String operatorCertificateNumber) {
        this.operatorCertificateNumber = operatorCertificateNumber;
    }

    public String getOperatorAddress() {
        return operatorAddress;
    }

    public void setOperatorAddress(String operatorAddress) {
        this.operatorAddress = operatorAddress;
    }

    public String getOperatorPostcode() {
        return operatorPostcode;
    }

    public void setOperatorPostcode(String operatorPostcode) {
        this.operatorPostcode = operatorPostcode;
    }

    public String getOperatorMobilePhone() {
        return operatorMobilePhone;
    }

    public void setOperatorMobilePhone(String operatorMobilePhone) {
        this.operatorMobilePhone = operatorMobilePhone;
    }

    public String getOperatorMail() {
        return operatorMail;
    }

    public void setOperatorMail(String operatorMail) {
        this.operatorMail = operatorMail;
    }

    public String getOperatorTel() {
        return operatorTel;
    }

    public void setOperatorTel(String operatorTel) {
        this.operatorTel = operatorTel;
    }
}
