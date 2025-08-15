package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:30
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishBody {
    @XmlElement(name = "ApasInfo")
    private FinishApasInfo apasInfo;

    @XmlElement(name = "Licenses")
    private FinishLicenses licenses;

    @XmlElement(name = "FormInfos")
    private FinishFormInfos formInfos;

    @XmlElement(name = "Attrs")
    private FinishAttrs attrs;

    @XmlElement(name = "ResultAttrs")
    private FinishResultAttrs resultAttrs;

    @XmlElement(name = "Documents")
    private FinishDocuments documents;

    @XmlElement(name = "SMS")
    private FinishSMS sms;

    public FinishApasInfo getApasInfo() {
        return apasInfo;
    }

    public void setApasInfo(FinishApasInfo apasInfo) {
        this.apasInfo = apasInfo;
    }

    public FinishLicenses getLicenses() {
        return licenses;
    }

    public void setLicenses(FinishLicenses licenses) {
        this.licenses = licenses;
    }

    public FinishFormInfos getFormInfos() {
        return formInfos;
    }

    public void setFormInfos(FinishFormInfos formInfos) {
        this.formInfos = formInfos;
    }

    public FinishAttrs getAttrs() {
        return attrs;
    }

    public void setAttrs(FinishAttrs attrs) {
        this.attrs = attrs;
    }

    public FinishResultAttrs getResultAttrs() {
        return resultAttrs;
    }

    public void setResultAttrs(FinishResultAttrs resultAttrs) {
        this.resultAttrs = resultAttrs;
    }

    public FinishDocuments getDocuments() {
        return documents;
    }

    public void setDocuments(FinishDocuments documents) {
        this.documents = documents;
    }

    public FinishSMS getSms() {
        return sms;
    }

    public void setSms(FinishSMS sms) {
        this.sms = sms;
    }
}
