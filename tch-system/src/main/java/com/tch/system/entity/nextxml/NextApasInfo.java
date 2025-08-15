package com.tch.system.entity.nextxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/3/20 14:55
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NextApasInfo {
    @XmlElement(name = "SN")
    private String SN;

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

}
