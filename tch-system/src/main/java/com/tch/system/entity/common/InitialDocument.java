package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/4/10 16:50
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class InitialDocument {

    @XmlElement(name = "Type")
    private String type;


    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "DocNo")
    private String docNo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }
}
