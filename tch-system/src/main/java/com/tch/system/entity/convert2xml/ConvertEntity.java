package com.tch.system.entity.convert2xml;

import com.tch.system.entity.common.ConvertBaseData;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Case")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConvertEntity extends ConvertBaseData {


    @XmlElement(name="Body")
    private ConvertBody body;


    public ConvertBody getBody() {
        return body;
    }

    public void setBody(ConvertBody body) {
        this.body = body;
    }
}

