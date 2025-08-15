package com.tch.system.entity.convert2xml;

import com.tch.system.entity.common.CovertFormInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:44
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FormInfos {
    @XmlElement(name = "FormInfo")
    public CovertFormInfo[] covertFormInfos;

    public CovertFormInfo[] getFormInfos() {
        return covertFormInfos;
    }

    public void setFormInfos(CovertFormInfo[] covertFormInfos) {
        this.covertFormInfos = covertFormInfos;
    }
}
