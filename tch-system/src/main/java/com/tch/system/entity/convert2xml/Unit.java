package com.tch.system.entity.convert2xml;

import com.tch.system.entity.common.CurrencyUnit;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Unit extends CurrencyUnit {


    @XmlTransient
    private  String unitId;


    @XmlTransient
    private String dataId;


    @XmlElement(name = "UnitAddress")
    private String unitAddress;

    @XmlElement(name = "UnitTel")
    private String unitTel;

    @XmlElement(name = "UnitPostcode")
    private String unitPostcode;

    @XmlElement(name = "CompanyPhone")
    private String companyPhone;


    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public String getUnitTel() {
        return unitTel;
    }

    public void setUnitTel(String unitTel) {
        this.unitTel = unitTel;
    }

    public String getUnitPostcode() {
        return unitPostcode;
    }

    public void setUnitPostcode(String unitPostcode) {
        this.unitPostcode = unitPostcode;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }
}
