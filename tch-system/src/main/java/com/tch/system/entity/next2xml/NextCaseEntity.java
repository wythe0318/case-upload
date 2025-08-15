package com.tch.system.entity.next2xml;


import com.tch.system.entity.common.ConvertBaseData;

import javax.xml.bind.annotation.*;

/**
 * @author duanjunlong
 * @data 2024/3/21 11:04
 */
@XmlRootElement(name = "Case")
@XmlAccessorType(XmlAccessType.FIELD)
public class NextCaseEntity extends ConvertBaseData {


    @XmlElement(name="Body")
    private NextBody body;

    public NextBody getBody() {
        return body;
    }

    public void setBody(NextBody body) {
        this.body = body;
    }
}
