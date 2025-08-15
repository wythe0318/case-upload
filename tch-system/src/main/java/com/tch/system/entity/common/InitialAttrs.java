package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/10 17:12
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InitialAttrs {
    @XmlElement(name = "Attr")
    private List<InitialAttr> attrList;

    public List<InitialAttr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<InitialAttr> attrList) {
        this.attrList = attrList;
    }
}
