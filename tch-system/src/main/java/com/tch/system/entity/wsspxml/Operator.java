package com.tch.system.entity.wsspxml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Operator {

    @XmlElement(name = "Name")
    private String name;

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

    @XmlElement(name = "MobilePhone")
    private String mobilePhone;

    @XmlElement(name = "Address")
    private String address;

    @XmlElement(name = "Postcode")
    private String postcode;

    @XmlElement(name = "Mail")
    private String mail;

    @XmlElement(name = "Tel")
    private String tel;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public String getCertificateType() {
        return this.certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }


    public String getCertificateName() {
        return this.certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }


    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }


    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
