package com.tch.system.entity.common;

import com.tch.system.entity.convert2xml.Person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/4/10 17:38
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CurrencyProposer {

    @XmlElement(name = "ApplyType")
    private String applyType;


    @XmlElement(name = "Person")
    private Person person;



    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
