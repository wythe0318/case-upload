package com.tch.system.entity.link2xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
    @XmlElement(name = "ConvertApasInfo")
    private ApasInfo apasInfo;

    @XmlElement(name = "Node")
    private Node node;

    public ApasInfo getApasInfo() {
        return apasInfo;
    }

    public void setApasInfo(ApasInfo apasInfo) {
        this.apasInfo = apasInfo;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
