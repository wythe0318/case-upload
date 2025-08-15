package com.tch.system.entity.nextxml;

import com.tch.system.entity.common.InitialDocument;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class NextDocument extends InitialDocument {
    @XmlElement(name = "DocUNID")
    private String unID;

    public String getUnID() {
        return unID;
    }

    public void setUnID(String unID) {
        this.unID = unID;
    }

}
