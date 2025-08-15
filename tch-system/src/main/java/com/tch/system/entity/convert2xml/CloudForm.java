package com.tch.system.entity.convert2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author duanjunlong
 * @data 2024/3/21 19:09
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CloudForm {

    @XmlTransient
    private String cloudFormId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "IntranetUrl")
    private String intranetUrl;

    @XmlElement(name = "OuternetUrl")
    private String outernetUrl;


    public String getCloudFormId() {
        return cloudFormId;
    }

    public void setCloudFormId(String cloudFormId) {
        this.cloudFormId = cloudFormId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getIntranetUrl() {
        return intranetUrl;
    }

    public void setIntranetUrl(String intranetUrl) {
        this.intranetUrl = intranetUrl;
    }


    public String getOuternetUrl() {
        return outernetUrl;
    }

    public void setOuternetUrl(String outernetUrl) {
        this.outernetUrl = outernetUrl;
    }
}
