package com.tch.system.entity.wsspxml;


import com.tch.system.entity.common.InitialExpress;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Expresses {

    @XmlElement(name = "Express")
    private InitialExpress express;


    public InitialExpress getExpress() {
        return express;
    }

    public void setExpress(InitialExpress express) {
        this.express = express;
    }
}
