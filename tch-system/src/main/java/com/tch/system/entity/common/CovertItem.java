package com.tch.system.entity.common;

import javax.xml.bind.annotation.*;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:43
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CovertItem {

    @XmlTransient
    private  String itemId;

    @XmlTransient
    private String dataId;

    @XmlAttribute(name = "alias")
    private String alias;

    @XmlAttribute(name = "field")
    private String field;

    @XmlValue
    private String value;


    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }



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
