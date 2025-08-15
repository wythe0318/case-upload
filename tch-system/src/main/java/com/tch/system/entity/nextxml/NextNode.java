package com.tch.system.entity.nextxml;



import com.tch.system.entity.next2xml.Attr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/3/20 14:52
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NextNode {

    @XmlElement(name = "Code")
    private String code;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "SName")
    private String sName;

    @XmlElement(name = "NextName")
    private String nextName;

    @XmlElement(name = "NextUser")
    private String nextUser;

    @XmlElement(name = "ProcessedUser")
    private String processedUser;

    @XmlElement(name = "StartTime")
    private String startTime;

    @XmlElement(name = "Modified")
    private String modified;

    @XmlElement(name = "Type")
    private String type;

    @XmlElement(name = "ProcessedOpinion")
    private String processedOpinion;

    @XmlElement(name = "PromiseEndTime")
    private String promiseEndTime;

    @XmlElement(name = "Remark")
    private String remark;

    @XmlElement(name = "Attrs")
    private Attr[] attrs;

    @XmlElement(name = "Documents")
    private NextDocuments documents;

    @XmlElement(name = "IsSpecial")
    private String isSpecial;

    @XmlElement(name = "NoAcptCause")
    private String noAcptCause;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getNextName() {
        return nextName;
    }

    public void setNextName(String nextName) {
        this.nextName = nextName;
    }

    public String getNextUser() {
        return nextUser;
    }

    public void setNextUser(String nextUser) {
        this.nextUser = nextUser;
    }

    public String getProcessedUser() {
        return processedUser;
    }

    public void setProcessedUser(String processedUser) {
        this.processedUser = processedUser;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProcessedOpinion() {
        return processedOpinion;
    }

    public void setProcessedOpinion(String processedOpinion) {
        this.processedOpinion = processedOpinion;
    }

    public String getPromiseEndTime() {
        return promiseEndTime;
    }

    public void setPromiseEndTime(String promiseEndTime) {
        this.promiseEndTime = promiseEndTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Attr[] getAttrs() {
        return attrs;
    }

    public void setAttrs(Attr[] attrs) {
        this.attrs = attrs;
    }

    public NextDocuments getDocuments() {
        return documents;
    }

    public void setDocuments(NextDocuments documents) {
        this.documents = documents;
    }

    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getNoAcptCause() {
        return noAcptCause;
    }

    public void setNoAcptCause(String noAcptCause) {
        this.noAcptCause = noAcptCause;
    }
}
