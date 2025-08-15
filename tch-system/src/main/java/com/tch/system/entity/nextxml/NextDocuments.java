package com.tch.system.entity.nextxml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/3/20 10:21
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NextDocuments {
    @XmlElement(name = "Document")
    private NextDocument[] document;

    public NextDocument[] getDocument() {
        return document;
    }

    public void setDocument(NextDocument[] document) {
        this.document = document;
    }
}
