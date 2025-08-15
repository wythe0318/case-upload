package com.tch.system.entity.xml2bean;

import com.tch.system.entity.common.InitialDocument;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:40
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishDocument  extends InitialDocument {
    @XmlElement(name = "UNID")
    private String unid;

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }
}
