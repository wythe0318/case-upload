package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author duanjunlong
 * @data 2024/3/20 10:19
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CovertDocument {

    @XmlTransient
    private String documentId;

    @XmlTransient
    private String dataId;

    @XmlElement(name = "DocUNID")
    private String docUNID;

    @XmlElement(name = "SwbType")
    private String swbType;

    @XmlElement(name = "SrcType")
    private String srcType;

    @XmlElement(name = "DocType")
    private String docType;

    @XmlElement(name = "DocName")
    private String docName;

    @XmlElement(name = "DocNo")
    private String docNo;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocUNID() {
        return docUNID;
    }

    public void setDocUNID(String docUNID) {
        this.docUNID = docUNID;
    }


    public String getSwbType() {
        return swbType;
    }

    public void setSwbType(String swbType) {
        this.swbType = swbType;
    }


    public String getSrcType() {
        return srcType;
    }

    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }


    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }


    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }


    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }
}

