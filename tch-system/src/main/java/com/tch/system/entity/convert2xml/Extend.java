package com.tch.system.entity.convert2xml;

import com.tch.system.entity.common.InitialExetend;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author duanjunlong
 * @data 2024/3/21 19:09
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Extend extends InitialExetend {

    @XmlTransient
    private String extendId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "BackflowSystem")
    private String backflowSystem;

    public String getBackflowSystem() {
        return backflowSystem;
    }

    public void setBackflowSystem(String backflowSystem) {
        this.backflowSystem = backflowSystem;
    }

    public String getExtendId() {
        return extendId;
    }

    public void setExtendId(String extendId) {
        this.extendId = extendId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }
}
