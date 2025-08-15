package com.tch.system.entity.convert2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ConvertBody {
    @XmlElement(name = "ApasInfo")
    private ConvertEntityApasInfo convertApasInfo;

    @XmlElement(name = "Proposer")
    private Proposer proposer;

    @XmlElement(name = "Operator")
    private Operator operator;

    @XmlElement(name = "Expresses")
    private Expresses expresses;

    @XmlElement(name = "Attrs")
    private List<Attr> attrs;

    @XmlElement(name = "Documents")
    private Documents documents;

    @XmlElement(name = "FormInfos")
    private FormInfos formInfos;

    @XmlElement(name = "SMS")
    private Sms sms;

    @XmlElement(name = "CloudForm")
    private CloudForm cloudForm;


    @XmlElement(name = "Extend")
    private Extend extend;


    public CloudForm getCloudForm() {
        return cloudForm;
    }

    public void setCloudForm(CloudForm cloudForm) {
        this.cloudForm = cloudForm;
    }

    public Sms getSms() {
        return sms;
    }

    public void setSms(Sms sms) {
        this.sms = sms;
    }

    public Extend getExtend() {
        return extend;
    }

    public void setExtend(Extend extend) {
        this.extend = extend;
    }

    public FormInfos getFormInfos() {
        return formInfos;
    }

    public void setFormInfos(FormInfos formInfos) {
        this.formInfos = formInfos;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }



    public ConvertEntityApasInfo getApasInfo() {
        return convertApasInfo;
    }

    public void setApasInfo(ConvertEntityApasInfo convertApasInfo) {
        this.convertApasInfo = convertApasInfo;
    }

    public Proposer getProposer() {
        return proposer;
    }

    public void setProposer(Proposer proposer) {
        this.proposer = proposer;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Expresses getExpresses() {
        return expresses;
    }

    public void setExpresses(Expresses expresses) {
        this.expresses = expresses;
    }

    public List<Attr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<Attr> attrs) {
        this.attrs = attrs;
    }
}
