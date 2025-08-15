package com.tch.system.entity.common;

import com.tch.common.core.domain.BaseEntity;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * @author duanjunlong
 * @data 2024/4/9 16:20
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ConvertBaseData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @XmlTransient
    private String resourceInfoType;

    @XmlTransient
    private String operationLogo;

    @XmlTransient
    private Date transferLogo;

    @XmlAttribute(name = "applyFrom")
    private String applyFrom;

    @XmlAttribute(name = "type")
    private String type;

    @XmlAttribute(name = "unid")
    private String unid;

    @XmlAttribute(name = "xsd")
    private String xsd;

    @XmlElement(name = "Router")
    private Router router;

    public Date getTransferLogo() {
        return transferLogo;
    }

    public void setTransferLogo(Date transferLogo) {
        this.transferLogo = transferLogo;
    }

    public String getApplyFrom() {
        return applyFrom;
    }

    public void setApplyFrom(String applyFrom) {
        this.applyFrom = applyFrom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getXsd() {
        return xsd;
    }

    public void setXsd(String xsd) {
        this.xsd = xsd;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }


    public String getResourceInfoType() {
        return resourceInfoType;
    }

    public void setResourceInfoType(String resourceInfoType) {
        this.resourceInfoType = resourceInfoType;
    }

    public String getOperationLogo() {
        return operationLogo;
    }

    public void setOperationLogo(String operationLogo) {
        this.operationLogo = operationLogo;
    }
}
