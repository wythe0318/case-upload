package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Document {
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
