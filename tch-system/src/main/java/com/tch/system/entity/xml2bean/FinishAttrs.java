package com.tch.system.entity.xml2bean;

import com.tch.system.entity.common.InitialAttr;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:42
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishAttrs {
    @XmlElement(name = "Attr")
    private InitialAttr[] finishAttrs;

    public InitialAttr[] getFinishAttrs() {
        return finishAttrs;
    }

    public void setFinishAttrs(InitialAttr[] finishAttrs) {
        this.finishAttrs = finishAttrs;
    }
}
