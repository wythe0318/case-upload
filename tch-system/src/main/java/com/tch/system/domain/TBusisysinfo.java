package com.tch.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tch.common.annotation.Excel;
import com.tch.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 业务系统推送到共享平台的业务数据对象 t_busisysinfo
 *
 * @author wythe
 * @date 2024-03-18
 */
public class TBusisysinfo extends BaseEntity{
     private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String unid;

    /**
     * 来源系统代码
     */
    @Excel(name = "来源系统代码")
    private String fromareacode;

    /**
     * 来源系统名称
     */
    @Excel(name = "来源系统名称")
    private String fromareaname;

    /**
     * 接收系统代码
     */
    @Excel(name = "接收系统代码")
    private String toareacode;

    /**
     * 接收系统名称
     */
    @Excel(name = "接收系统名称")
    private String toareaname;

    /**
     * 来源
     */
    @Excel(name = "来源")
    private String applyfrom;

    /**
     * 类型
     */
    @Excel(name = "类型")
    private String type;


    @Excel(name = "创建时间")
    private Date createtime;

    /**
     * XML内容
     */
    @Excel(name = "XML内容")
    private byte[] content;

    /**
     * XSD类型
     */
    @Excel(name = "XSD类型")
    private String xsdtype;

    /**
     * XSD版本号
     */
    @Excel(name = "XSD版本号")
    private String copyright;

    /**
     * 备用字符字段1
     */
    @Excel(name = "备用字符字段1")
    private String tchar1;

    /**
     * 备用字符字段2
     */
    @Excel(name = "备用字符字段2")
    private String tchar2;

    /**
     * 备用字符字段3
     */
    @Excel(name = "备用字符字段3")
    private String tchar3;

    /**
     * 备用字符字段4
     */
    @Excel(name = "备用字符字段4")
    private String tchar4;

    /**
     * 备用二进制字段1
     */
    @Excel(name = "备用二进制字段1")
    private byte[] tblob1;

    /**
     * 备用二进制字段2
     */
    @Excel(name = "备用二进制字段2")
    private byte[] tblob2;

    /**
     * 操作状态
     */
    @Excel(name = "操作状态")
    private String action;

    /**
     * 系统时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "系统时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date systime;

    /**
     * 同步状态
     */
    @Excel(name = "同步状态")
    private String syncstate;

    /**
     * 同步时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "同步时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date synctime;

    /**
     * 同步情况
     */
    @Excel(name = "同步情况")
    private String syncdesc;


    @Excel(name = "通报情况")
    private String remark;
    /**
     * 业务编号
     */
    @Excel(name = "业务编号")
    private String busino;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String batchno;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date systime2;

    /**
     * 是否成功存入办件库
     */
    @Excel(name = "是否成功存入办件库")
    private String isSuccess;

    private  byte[] newContent;

    public byte[] getNewContent() {
        return newContent;
    }

    public void setNewContent(byte[] newContent) {
        this.newContent = newContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public String getUnid() {
        return unid;
    }

    public void setFromareacode(String fromareacode) {
        this.fromareacode = fromareacode;
    }

    public String getFromareacode() {
        return fromareacode;
    }

    public void setFromareaname(String fromareaname) {
        this.fromareaname = fromareaname;
    }

    public String getFromareaname() {
        return fromareaname;
    }

    public void setToareacode(String toareacode) {
        this.toareacode = toareacode;
    }

    public String getToareacode() {
        return toareacode;
    }

    public void setToareaname(String toareaname) {
        this.toareaname = toareaname;
    }

    public String getToareaname() {
        return toareaname;
    }

    public void setApplyfrom(String applyfrom) {
        this.applyfrom = applyfrom;
    }

    public String getApplyfrom() {
        return applyfrom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }

    public void setXsdtype(String xsdtype) {
        this.xsdtype = xsdtype;
    }

    public String getXsdtype() {
        return xsdtype;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setTchar1(String tchar1) {
        this.tchar1 = tchar1;
    }

    public String getTchar1() {
        return tchar1;
    }

    public void setTchar2(String tchar2) {
        this.tchar2 = tchar2;
    }

    public String getTchar2() {
        return tchar2;
    }

    public void setTchar3(String tchar3) {
        this.tchar3 = tchar3;
    }

    public String getTchar3() {
        return tchar3;
    }

    public void setTchar4(String tchar4) {
        this.tchar4 = tchar4;
    }

    public String getTchar4() {
        return tchar4;
    }

    public byte[] getTblob1() {
        return tblob1;
    }

    public void setTblob1(byte[] tblob1) {
        this.tblob1 = tblob1;
    }

    public byte[] getTblob2() {
        return tblob2;
    }

    public void setTblob2(byte[] tblob2) {
        this.tblob2 = tblob2;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    public Date getSystime() {
        return systime;
    }

    public void setSyncstate(String syncstate) {
        this.syncstate = syncstate;
    }

    public String getSyncstate() {
        return syncstate;
    }

    public void setSynctime(Date synctime) {
        this.synctime = synctime;
    }

    public Date getSynctime() {
        return synctime;
    }

    public void setSyncdesc(String syncdesc) {
        this.syncdesc = syncdesc;
    }

    public String getSyncdesc() {
        return syncdesc;
    }

    public void setBusino(String busino) {
        this.busino = busino;
    }

    public String getBusino() {
        return busino;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setSystime2(Date systime2) {
        this.systime2 = systime2;
    }

    public Date getSystime2() {
        return systime2;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("unid", getUnid())
                .append("fromareacode", getFromareacode())
                .append("fromareaname", getFromareaname())
                .append("toareacode", getToareacode())
                .append("toareaname", getToareaname())
                .append("applyfrom", getApplyfrom())
                .append("type", getType())
                .append("createtime", getCreatetime())
                .append("content", getContent())
                .append("xsdtype", getXsdtype())
                .append("copyright", getCopyright())
                .append("tchar1", getTchar1())
                .append("tchar2", getTchar2())
                .append("tchar3", getTchar3())
                .append("tchar4", getTchar4())
                .append("tblob1", getTblob1())
                .append("tblob2", getTblob2())
                .append("action", getAction())
                .append("systime", getSystime())
                .append("syncstate", getSyncstate())
                .append("synctime", getSynctime())
                .append("syncdesc", getSyncdesc())
                .append("remark", getRemark())
                .append("busino", getBusino())
                .append("batchno", getBatchno())
                .append("systime2", getSystime2())
                .append("isSuccess", getIsSuccess())
                .toString();
    }
}
