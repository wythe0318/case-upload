package com.tch.system.entity.next2xml;

import com.tch.system.entity.common.ConvertApasInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author duanjunlong
 * @data 2024/3/20 15:34
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NextConvertApasInfo extends ConvertApasInfo {
    @XmlTransient
    private String nextApasInfoId;

    @XmlTransient
    private String busISysInfoUuid;


    @XmlElement(name = "ApplyType")
    private String applyType;

    @XmlElement(name = "ReceiveDeptName")
    private String receiveDeptName;


    @XmlElement(name = "ReceiveDeptCode")
    private String receiveDeptCode;

    @XmlElement(name = "SwbSN")
    private String swbSN;

    @XmlElement(name = "SrcSN")
    private String srcSN;

    @XmlElement(name = "SeqNo")
    private String seqNo;

    @XmlElement(name = "Version")
    private int version;


    public String getNextApasInfoId() {
        return nextApasInfoId;
    }

    public void setNextApasInfoId(String nextApasInfoId) {
        this.nextApasInfoId = nextApasInfoId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }


    public String getSwbSN() {
        return swbSN;
    }

    public void setSwbSN(String swbSN) {
        this.swbSN = swbSN;
    }

    public String getSrcSN() {
        return srcSN;
    }

    public void setSrcSN(String srcSN) {
        this.srcSN = srcSN;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    public String getReceiveDeptName() {
        return receiveDeptName;
    }

    public void setReceiveDeptName(String receiveDeptName) {
        this.receiveDeptName = receiveDeptName;
    }

    public String getReceiveDeptCode() {
        return receiveDeptCode;
    }

    public void setReceiveDeptCode(String receiveDeptCode) {
        this.receiveDeptCode = receiveDeptCode;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }
}

