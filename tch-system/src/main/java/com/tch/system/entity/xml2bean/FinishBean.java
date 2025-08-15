package com.tch.system.entity.xml2bean;

import com.tch.system.entity.common.ConvertBaseData;

import javax.xml.bind.annotation.*;
/**
 * @author ：Wythe
 * @description：审批结果xml转实体bean
 * @date ：2024/03/20 15:20
 */

@XmlRootElement(name = "Case")
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishBean extends ConvertBaseData {

    @XmlElement(name = "Body")
    private FinishBody body;

    public FinishBody getBody() {
        return body;
    }

    public void setBody(FinishBody body) {
        this.body = body;
    }

}

