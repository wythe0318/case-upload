package com.tch.system.entity.convert2xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlTransient
    private String wsspPersonId;

    @XmlTransient
    private String dataId;

    @XmlElement(name = "ApplyName")
    private String applyName;

    @XmlElement(name = "Sex")
    private String sex;

    @XmlElement(name = "Birthday")
    private String birthday;

    @XmlElement(name = "CertificateType")
    private String certificateType;

    @XmlElement(name = "CertificateName")
    private String certificateName;

    @XmlElement(name = "CertificateNumber")
    private String certificateNumber;

    @XmlElement(name = "Address")
    private String address;

    @XmlElement(name = "Postcode")
    private String postcode;

    @XmlElement(name = "MobilePhone")
    private String mobilePhone;

    @XmlElement(name = "Mail")
    private String mail;

    @XmlElement(name = "Tel")
    private String tel;


    public String getWsspPersonId() {
        return wsspPersonId;
    }

    public void setWsspPersonId(String wsspPersonId) {
        this.wsspPersonId = wsspPersonId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
