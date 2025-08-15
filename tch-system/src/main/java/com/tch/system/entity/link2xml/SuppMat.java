package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SuppMat {
    private  String suppMatId;

    private String dataId;
    @XmlElement(name = "SMType")
    private String smType;

    @XmlElement(name = "SuppMatStart")
    private SuppMatStart suppMatStart;

    @XmlElement(name = "SuppMatEnd")
    private SuppMatEnd suppMatEnd;


    public String getSuppMatId() {
        return suppMatId;
    }

    public void setSuppMatId(String suppMatId) {
        this.suppMatId = suppMatId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getSmType() {
        return smType;
    }

    public void setSmType(String smType) {
        this.smType = smType;
    }

    public SuppMatStart getSuppMatStart() {
        return suppMatStart;
    }

    public void setSuppMatStart(SuppMatStart suppMatStart) {
        this.suppMatStart = suppMatStart;
    }

    public SuppMatEnd getSuppMatEnd() {
        return suppMatEnd;
    }

    public void setSuppMatEnd(SuppMatEnd suppMatEnd) {
        this.suppMatEnd = suppMatEnd;
    }
}
