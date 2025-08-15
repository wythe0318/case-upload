package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/4/10 16:53
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CovertDocuments {
    @XmlElement(name = "Document")
    private CovertDocument[] covertDocument;

    public CovertDocument[] getCovertDocument() {
        return covertDocument;
    }

    public void setCovertDocument(CovertDocument[] covertDocuments) {
        this.covertDocument = covertDocuments;
    }
}
