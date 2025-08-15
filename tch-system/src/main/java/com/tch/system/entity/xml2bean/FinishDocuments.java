package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:41
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishDocuments {
    @XmlElement(name = "Document")
    private FinishDocument[] document;

    public FinishDocument[] getDocument() {
        return document;
    }

    public void setDocument(FinishDocument[] document) {
        this.document = document;
    }
}
