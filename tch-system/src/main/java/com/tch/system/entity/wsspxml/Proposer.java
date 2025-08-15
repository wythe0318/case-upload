package com.tch.system.entity.wsspxml;



import com.tch.system.entity.common.CurrencyProposer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Proposer extends CurrencyProposer {

    @XmlElement(name = "AreaCode")
    private String areaCode;

    @XmlElement(name = "Unit")
    private Unit unit;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
