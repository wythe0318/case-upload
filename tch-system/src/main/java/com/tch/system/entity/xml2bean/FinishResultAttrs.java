package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:41
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishResultAttrs {
    @XmlElement(name = "ResultAttr")
    private FinishResultAttr[] resultAttrs;

    public FinishResultAttr[] getResultAttrs() {
        return resultAttrs;
    }

    public void setResultAttrs(FinishResultAttr[] resultAttrs) {
        this.resultAttrs = resultAttrs;
    }
}
