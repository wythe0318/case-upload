package com.tch.system.entity.convert2xml;

import com.tch.system.entity.common.CurrencyProposer;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Proposer extends CurrencyProposer {
    @XmlTransient
    private String proposerId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "ApplyObjAreaCode")
    private String applyObjAreaCode;

    @XmlElement(name = "Unit")
    private Unit unit;


    public String getProposerId() {
        return proposerId;
    }

    public void setProposerId(String proposerId) {
        this.proposerId = proposerId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getApplyObjAreaCode() {
        return applyObjAreaCode;
    }

    public void setApplyObjAreaCode(String applyObjAreaCode) {
        this.applyObjAreaCode = applyObjAreaCode;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
