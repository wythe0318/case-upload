package com.tch.system.domain;

import com.tch.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @author duanjunlong
 * @data 2024/4/11 14:57
 */

public class TResourceInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String unId;
    private String fromAreaCode;
    private String fromAreaName;
    private String toAreaCode;
    private String toAreaName;
    private String applyFrom;
    private String type;
    private Date createTime;
    private byte[] content;
    private String xsdType;
    private String copyright;
    private String tchar1;
    private String tchar2;
    private String tchar3;
    private String tchar4;
    private byte[] tblob1;
    private byte[] tblob2;
    private String action;
    private Date sysTime;
    private String syncState;
    private Date syncTime;
    private String syncDesc;
    private String remark;
    private String busiNo;
    private Date sysTime2;
    private String batchNo;


    public String getUnId() {
        return unId;
    }

    public void setUnId(String unId) {
        this.unId = unId;
    }

    public String getFromAreaCode() {
        return fromAreaCode;
    }

    public void setFromAreaCode(String fromAreaCode) {
        this.fromAreaCode = fromAreaCode;
    }

    public String getFromAreaName() {
        return fromAreaName;
    }

    public void setFromAreaName(String fromAreaName) {
        this.fromAreaName = fromAreaName;
    }

    public String getToAreaCode() {
        return toAreaCode;
    }

    public void setToAreaCode(String toAreaCode) {
        this.toAreaCode = toAreaCode;
    }

    public String getToAreaName() {
        return toAreaName;
    }

    public void setToAreaName(String toAreaName) {
        this.toAreaName = toAreaName;
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

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getXsdType() {
        return xsdType;
    }

    public void setXsdType(String xsdType) {
        this.xsdType = xsdType;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getTchar1() {
        return tchar1;
    }

    public void setTchar1(String tchar1) {
        this.tchar1 = tchar1;
    }

    public String getTchar2() {
        return tchar2;
    }

    public void setTchar2(String tchar2) {
        this.tchar2 = tchar2;
    }

    public String getTchar3() {
        return tchar3;
    }

    public void setTchar3(String tchar3) {
        this.tchar3 = tchar3;
    }

    public String getTchar4() {
        return tchar4;
    }

    public void setTchar4(String tchar4) {
        this.tchar4 = tchar4;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getSysTime() {
        return sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }

    public String getSyncState() {
        return syncState;
    }

    public void setSyncState(String syncState) {
        this.syncState = syncState;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    public String getSyncDesc() {
        return syncDesc;
    }

    public void setSyncDesc(String syncDesc) {
        this.syncDesc = syncDesc;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBusiNo() {
        return busiNo;
    }

    public void setBusiNo(String busiNo) {
        this.busiNo = busiNo;
    }

    public Date getSysTime2() {
        return sysTime2;
    }

    public void setSysTime2(Date sysTime2) {
        this.sysTime2 = sysTime2;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
