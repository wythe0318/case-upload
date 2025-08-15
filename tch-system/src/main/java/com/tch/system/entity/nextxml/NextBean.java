package com.tch.system.entity.nextxml;

import com.tch.system.entity.common.ConvertBaseData;

import javax.xml.bind.annotation.*;

/**过程信息类
 * @author duanjunlong
 * @data 2024/3/19 9:08
 */
@XmlRootElement(name = "Case")
@XmlAccessorType(XmlAccessType.FIELD)
public class NextBean extends ConvertBaseData {

    @XmlElement(name = "Body")
    private NextBody nextBody;

    public NextBody getNextBody() {
        return nextBody;
    }

    public void setNextBody(NextBody nextBody) {
        this.nextBody = nextBody;
    }

}







