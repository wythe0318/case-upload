package com.tch.system.entity.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author duanjunlong
 * @data 2024/4/10 17:25
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InitialExetend {

    @XmlElement(name = "IsAgentService")
    private String isAgentService;

    @XmlElement(name = "AgentServiceCharge")
    private String agentServiceCharge;

    @XmlElement(name = "Backflow")
    private String backflow;

    @XmlElement(name = "GzcnspFlag")
    private String gzcnspFlag;

    @XmlElement(name = "GzcnspFileUnid")
    private String gzcnspFileUnid;

    @XmlElement(name = "GzcnspFileName")
    private String gzcnspFileName;


    @XmlElement(name = "AgentSourceArea")
    private String agentSourceArea;

    @XmlElement(name = "CertifiedIsWriteOff")
    private String certifiedIsWriteOff;


    public String getIsAgentService() {
        return isAgentService;
    }

    public void setIsAgentService(String isAgentService) {
        this.isAgentService = isAgentService;
    }

    public String getAgentServiceCharge() {
        return agentServiceCharge;
    }

    public void setAgentServiceCharge(String agentServiceCharge) {
        this.agentServiceCharge = agentServiceCharge;
    }

    public String getBackflow() {
        return backflow;
    }

    public void setBackflow(String backflow) {
        this.backflow = backflow;
    }

    public String getGzcnspFlag() {
        return gzcnspFlag;
    }

    public void setGzcnspFlag(String gzcnspFlag) {
        this.gzcnspFlag = gzcnspFlag;
    }

    public String getGzcnspFileUnid() {
        return gzcnspFileUnid;
    }

    public void setGzcnspFileUnid(String gzcnspFileUnid) {
        this.gzcnspFileUnid = gzcnspFileUnid;
    }

    public String getGzcnspFileName() {
        return gzcnspFileName;
    }

    public void setGzcnspFileName(String gzcnspFileName) {
        this.gzcnspFileName = gzcnspFileName;
    }

    public String getAgentSourceArea() {
        return agentSourceArea;
    }

    public void setAgentSourceArea(String agentSourceArea) {
        this.agentSourceArea = agentSourceArea;
    }

    public String getCertifiedIsWriteOff() {
        return certifiedIsWriteOff;
    }

    public void setCertifiedIsWriteOff(String certifiedIsWriteOff) {
        this.certifiedIsWriteOff = certifiedIsWriteOff;
    }
}
