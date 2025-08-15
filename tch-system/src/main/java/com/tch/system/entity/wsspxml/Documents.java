package com.tch.system.entity.wsspxml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Documents {
    @XmlElement(name = "Document")
    private Document[] document;


    public Document[] getDocument() {
        return document;
    }

    public void setDocument(Document[] document) {
        this.document = document;
    }
}
