package com.tch.system.entity.xml2bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:43
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FinishItem {
    @XmlAttribute(name = "alias")
    private String alias;

    @XmlAttribute(name = "field")
    private String field;

    @XmlValue
    private String value;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
