package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/4/10 17:44
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyUnit {

    @XmlElement(name = "UnitName")
    private String unitName;

    @XmlElement(name = "UnitCode")
    private String unitCode;

    @XmlElement(name = "UnitType")
    private String unitType;

    @XmlElement(name = "UnitIdcardType")
    private String unitIdcardType;

    @XmlElement(name = "LealPerson")
    private String lealPerson;

    @XmlElement(name = "LegalIdcardType")
    private String legalIdcardType;

    @XmlElement(name = "LegalIdcard")
    private String legalIdcard;


    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUnitIdcardType() {
        return unitIdcardType;
    }

    public void setUnitIdcardType(String unitIdcardType) {
        this.unitIdcardType = unitIdcardType;
    }

    public String getLealPerson() {
        return lealPerson;
    }

    public void setLealPerson(String lealPerson) {
        this.lealPerson = lealPerson;
    }

    public String getLegalIdcardType() {
        return legalIdcardType;
    }

    public void setLegalIdcardType(String legalIdcardType) {
        this.legalIdcardType = legalIdcardType;
    }

    public String getLegalIdcard() {
        return legalIdcard;
    }

    public void setLegalIdcard(String legalIdcard) {
        this.legalIdcard = legalIdcard;
    }
}
