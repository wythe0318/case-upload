package com.tch.system.entity.convert2xml;

import com.tch.system.entity.common.InitialExpress;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Express extends InitialExpress {

    @XmlTransient
    private String expressId;

    @XmlTransient
    private String busISysInfoUuid;



    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

}
