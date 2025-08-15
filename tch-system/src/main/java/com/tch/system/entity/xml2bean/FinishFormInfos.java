package com.tch.system.entity.xml2bean;

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
public class FinishFormInfos {
    @XmlElement(name = "FormInfo")
    private CovertFormInfo[] formInfos;

    public CovertFormInfo[] getFormInfos() {
        return formInfos;
    }

    public void setFormInfos(CovertFormInfo[] formInfos) {
        this.formInfos = formInfos;
    }
}
