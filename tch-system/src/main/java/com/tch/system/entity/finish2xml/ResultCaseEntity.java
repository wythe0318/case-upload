package com.tch.system.entity.finish2xml;

import com.tch.system.entity.common.ConvertBaseData;

import javax.xml.bind.annotation.*;


/**
 * 审批结果转xml实体类
 */
@XmlRootElement(name = "Case")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultCaseEntity extends ConvertBaseData {

    @XmlElement(name = "Body")
    private FinishBody finishBody;

    public FinishBody getFinishBody() {
        return finishBody;
    }

    public void setFinishBody(FinishBody finishBody) {
        this.finishBody = finishBody;
    }
}

