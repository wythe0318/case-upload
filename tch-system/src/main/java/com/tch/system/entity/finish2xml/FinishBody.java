package com.tch.system.entity.finish2xml;

import com.tch.system.entity.common.CovertDocuments;
import com.tch.system.entity.xml2bean.FinishFormInfos;
import com.tch.system.entity.xml2bean.FinishLicenses;
import com.tch.system.entity.xml2bean.FinishResultAttrs;
import com.tch.system.entity.xml2bean.FinishSMS;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 10:20
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
    private Attrs attrs;

    @XmlElement(name = "ResultAttrs")
    private FinishResultAttrs resultAttrs;

    @XmlElement(name = "Documents")
    private CovertDocuments documents;

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

    public Attrs getAttrs() {
        return attrs;
    }

    public void setAttrs(Attrs attrs) {
        this.attrs = attrs;
    }

    public FinishResultAttrs getResultAttrs() {
        return resultAttrs;
    }

    public void setResultAttrs(FinishResultAttrs resultAttrs) {
        this.resultAttrs = resultAttrs;
    }

    public FinishSMS getSms() {
        return sms;
    }

    public void setSms(FinishSMS sms) {
        this.sms = sms;
    }

    public CovertDocuments getDocuments() {
        return documents;
    }

    public void setDocuments(CovertDocuments documents) {
        this.documents = documents;
    }
}
