package com.tch.system.entity.wsspxml;



import com.tch.system.entity.common.CurrencyUnit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Unit  extends CurrencyUnit {
    @XmlElement(name = "Address")
    private String address;

    @XmlElement(name = "Tel")
    private String tel;

    @XmlElement(name = "Postcode")
    private String postcode;

    @XmlElement(name = "CompanyPhone")
    private String companyPhone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }
}
