package com.tch.system.entity.wsspxml;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import javax.xml.bind.annotation.XmlElement;

public class Person {
    private String applyName;
    private String certificateType;
    private String certificateName;
    private String certificateNumber;
    private String mobilePhone;
    private String sex;
    private String birthday;
    private String address;
    private String postcode;
    private String mail;
    private String tel;

    @XmlElement(name = "ApplyName")
    public String getApplyName() {
        return this.applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    @XmlElement(name = "CertificateType")
    public String getCertificateType() {
        return this.certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    @XmlElement(name = "CertificateName")
    public String getCertificateName() {
        return this.certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    @XmlElement(name = "CertificateNumber")
    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    @XmlElement(name = "MobilePhone")
    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @XmlElement(name = "Sex")
    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @XmlElement(name = "Birthday")
    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @XmlElement(name = "Address")
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement(name = "Postcode")
    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @XmlElement(name = "Mail")
    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @XmlElement(name = "Tel")
    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
