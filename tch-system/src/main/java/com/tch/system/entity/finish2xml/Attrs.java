package com.tch.system.entity.finish2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 10:18
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Attrs {
    @XmlElement(name = "Attr")
    private FinishAttr[] finishAttrs;

    public FinishAttr[] getAttrs() {
        return finishAttrs;
    }

    public void setAttrs(FinishAttr[] finishAttrs) {
        this.finishAttrs = finishAttrs;
    }
}
