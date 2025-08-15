package com.tch.system.entity.convert2xml;

import com.tch.system.entity.common.CovertDocument;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/3/20 10:21
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Documents {
    @XmlElement(name = "Document")
    private CovertDocument[] covertDocument;

    public CovertDocument[] getDocument() {
        return covertDocument;
    }

    public void setDocument(CovertDocument[] covertDocument) {
        this.covertDocument = covertDocument;
    }


}
