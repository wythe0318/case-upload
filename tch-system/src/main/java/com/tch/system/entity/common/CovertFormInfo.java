package com.tch.system.entity.common;



import javax.xml.bind.annotation.*;

/**
 * @author ：Wythe
 * @description：TODO
 * @date ：2024/03/20 15:43
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CovertFormInfo {

    @XmlTransient
    private String formInfoId;

    @XmlTransient
    private String busISysInfoUuid;

    @XmlElement(name = "UNID")
    private String unid;

    @XmlElement(name = "FormName")
    private String formName;

    @XmlElement(name = "FormAlias")
    private String formAlias;

    @XmlElementWrapper(name = "Items")
    @XmlElement(name = "Item")
    private CovertItem[] covertItems;

    public String getFormInfoId() {
        return formInfoId;
    }

    public void setFormInfoId(String formInfoId) {
        this.formInfoId = formInfoId;
    }

    public String getBusISysInfoUuid() {
        return busISysInfoUuid;
    }

    public void setBusISysInfoUuid(String busISysInfoUuid) {
        this.busISysInfoUuid = busISysInfoUuid;
    }

    public String getUnid() {
        return unid;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormAlias() {
        return formAlias;
    }

    public void setFormAlias(String formAlias) {
        this.formAlias = formAlias;
    }

    public CovertItem[] getItems() {
        return covertItems;
    }

    public void setItems(CovertItem[] covertItems) {
        this.covertItems = covertItems;
    }
}
