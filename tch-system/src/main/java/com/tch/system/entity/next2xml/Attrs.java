package com.tch.system.entity.next2xml;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Attrs {
    @XmlElement(name = "Attr")
    private Attr[] attrList;

    public Attr[] getAttrList() {
        return attrList;
    }

    public void setAttrList(Attr[] attrList) {
        this.attrList = attrList;
    }
}
