package com.tch.system.entity.common;

import com.tch.system.entity.convert2xml.Attr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ConvertAttrs {
    @XmlElement(name = "Attr")
    private List<Attr> attrList;

    public List<Attr> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<Attr> attrList) {
        this.attrList = attrList;
    }
}
