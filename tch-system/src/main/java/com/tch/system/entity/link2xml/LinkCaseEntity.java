package com.tch.system.entity.link2xml;

import com.tch.system.entity.common.ConvertBaseData;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Case")
@XmlAccessorType(XmlAccessType.FIELD)
public class LinkCaseEntity extends ConvertBaseData {


    @XmlElement(name = "Body")
    private Body body;


    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
