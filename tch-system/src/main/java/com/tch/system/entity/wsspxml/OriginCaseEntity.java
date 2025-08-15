package com.tch.system.entity.wsspxml;

/**
 * @author duanjunlong
 * @data 2024/4/9 9:56
 */

import com.tch.system.entity.common.ConvertBaseData;
import com.tch.system.entity.convert2xml.FormInfos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Case")
@XmlAccessorType(XmlAccessType.FIELD)
public class OriginCaseEntity extends ConvertBaseData {
    @XmlElement(name = "Body")
    private Body body;

    @XmlElement(name = "FormInfos", nillable = true)
    private FormInfos formInfos;


    public FormInfos getFormInfos() {
        return this.formInfos;
    }

    public void setFormInfos(FormInfos formInfos) {
        this.formInfos = formInfos;
    }


    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

}
