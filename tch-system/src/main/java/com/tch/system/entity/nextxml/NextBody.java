package com.tch.system.entity.nextxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/3/20 14:54
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NextBody {
    @XmlElement(name = "ApasInfo")
    private NextApasInfo nextApasInfo;

    @XmlElement(name = "Node")
    private NextNode nextNode;



    public NextApasInfo getNextApasInfo() {
        return nextApasInfo;
    }

    public void setNextApasInfo(NextApasInfo nextApasInfo) {
        this.nextApasInfo = nextApasInfo;
    }


    public NextNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(NextNode nextNode) {
        this.nextNode = nextNode;
    }



}
