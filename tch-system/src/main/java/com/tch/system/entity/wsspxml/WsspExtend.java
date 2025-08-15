package com.tch.system.entity.wsspxml;

import com.tch.system.entity.common.InitialExetend;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/4/15 16:51
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsspExtend extends InitialExetend {

    @XmlElement(name = "ClassifyUnids")
    private String classifyUnids;

    @XmlElement(name = "ClassifyNames")
    private String classifyNames;

    @XmlElement(name = "OnlineTable")
    private String onlineTable;

    public String getOnlineTable() {
        return onlineTable;
    }

    public void setOnlineTable(String onlineTable) {
        this.onlineTable = onlineTable;
    }

    public String getClassifyUnids() {
        return classifyUnids;
    }

    public void setClassifyUnids(String classifyUnids) {
        this.classifyUnids = classifyUnids;
    }

    public String getClassifyNames() {
        return classifyNames;
    }

    public void setClassifyNames(String classifyNames) {
        this.classifyNames = classifyNames;
    }
}
