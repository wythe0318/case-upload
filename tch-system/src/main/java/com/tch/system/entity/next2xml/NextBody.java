package com.tch.system.entity.next2xml;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/3/20 15:33
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NextBody {
    @XmlElement(name = "ApasInfo")
    private NextConvertApasInfo next2ApasInf;

    @XmlElement(name = "Node")
    private NextNode nextNode;

    public NextConvertApasInfo getApasInfo() {
        return next2ApasInf;
    }

    public void setApasInfo(NextConvertApasInfo next2ApasInf) {
        this.next2ApasInf = next2ApasInf;
    }

    public NextNode getNode() {
        return nextNode;
    }

    public void setNode(NextNode nextNode) {
        this.nextNode = nextNode;
    }
}
