package com.tch.system.entity.wsspxml;


import com.tch.system.entity.common.InitialDocument;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Document extends InitialDocument {
    @XmlElement(name = "UNID")
    private String unid;

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }
}
