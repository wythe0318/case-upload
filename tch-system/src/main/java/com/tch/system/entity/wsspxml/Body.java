package com.tch.system.entity.wsspxml;
import com.tch.system.entity.common.InitialAttrs;
import com.tch.system.entity.convert2xml.CloudForm;
import com.tch.system.entity.convert2xml.FormInfos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
    @XmlElement(name = "ApasInfo")
    private ApasInfo apasInfo;
    @XmlElement(name = "Proposer")
    private Proposer proposer;

    @XmlElement(name = "Operator")
    private Operator operator;

    @XmlElement(name = "Expresses")
    private Expresses expresses;

    @XmlElement(name = "Attrs")
    private InitialAttrs attrs;

    @XmlElement(name = "FormInfos")
    private FormInfos formInfos;

    @XmlElement(name = "Documents")
    private Documents documents;

    @XmlElement(name = "SMS")
    private Sms sms;

    @XmlElement(name = "CloudForm")
    private CloudForm cloudForm;

    @XmlElement(name = "Extend")
    private WsspExtend extend;


    public ApasInfo getApasInfo() {
        return apasInfo;
    }

    public void setApasInfo(ApasInfo apasInfo) {
        this.apasInfo = apasInfo;
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

    public InitialAttrs getAttrs() {
        return attrs;
    }

    public void setAttrs(InitialAttrs attrs) {
        this.attrs = attrs;
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

    public Sms getSms() {
        return sms;
    }

    public void setSms(Sms sms) {
        this.sms = sms;
    }

    public CloudForm getCloudForm() {
        return cloudForm;
    }

    public void setCloudForm(CloudForm cloudForm) {
        this.cloudForm = cloudForm;
    }

    public WsspExtend getExtend() {
        return extend;
    }

    public void setExtend(WsspExtend extend) {
        this.extend = extend;
    }
}
