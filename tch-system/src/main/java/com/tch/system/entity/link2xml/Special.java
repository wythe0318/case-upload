package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Special {
    @XmlElement(name = "SpecialStart")
    private SpecialStart specialStart;

    @XmlElement(name = "SpecialEnd")
    private SpecialEnd specialEnd;

    public SpecialStart getSpecialStart() {
        return specialStart;
    }

    public void setSpecialStart(SpecialStart specialStart) {
        this.specialStart = specialStart;
    }

    public SpecialEnd getSpecialEnd() {
        return specialEnd;
    }

    public void setSpecialEnd(SpecialEnd specialEnd) {
        this.specialEnd = specialEnd;
    }
}
