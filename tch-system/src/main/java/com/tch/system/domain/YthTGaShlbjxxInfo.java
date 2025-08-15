package com.tch.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tch.common.annotation.Excel;
import com.tch.common.core.domain.BaseEntity;

/**
 * caseUpload对象 yth_t_ga_shlbjxx_info
 * 
 * @author Wythe
 * @date 2024-03-17
 */
public class YthTGaShlbjxxInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String provincePullDataAuditId;

    /** 办件编号 */
    @Excel(name = "办件编号")
    private String sn;

    /** 数据推送方社会信用代码 */
    @Excel(name = "数据推送方社会信用代码")
    private String fromCode;

    /** 办件信息xml */
    @Excel(name = "办件信息xml")
    private String wsspXml;

    /** 过程信息xml */
    @Excel(name = "过程信息xml")
    private String nextXml;

    /** 计时暂停xml */
    @Excel(name = "计时暂停xml")
    private String suspendXml;

    /** 计时恢复xml */
    @Excel(name = "计时恢复xml")
    private String resumeXml;

    /** 结果信息xml */
    @Excel(name = "结果信息xml")
    private String finishXml;

    /** 邮递服务xml */
    @Excel(name = "邮递服务xml")
    private String expressXml;

    /** 时间戳 格式：yyyy-MM-dd HH:mm:ss */
    @Excel(name = "时间戳 格式：yyyy-MM-dd HH:mm:ss")
    private String auditTimestamp;

    /** 创建记录的系统时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建记录的系统时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 修改记录的系统时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改记录的系统时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    /** 记录的版本 */
    @Excel(name = "记录的版本")
    private Long version;

    /** 数据创建人ID */
    @Excel(name = "数据创建人ID")
    private String createdUserId;

    /** 数据更新人ID */
    @Excel(name = "数据更新人ID")
    private String updatedUserId;

    /** 扩展字段，json对象,示例：{"SN":?"办件编号","fromCode":?"数据推送方社会信用代码",//例省住建厅：113500000035912564"projectCode":?"项目代码",//涉及工改的办件数据为必填"coprojectName":?"协同项目名称","toCode":?"地市或者市县编码","nationalSysid":?"国家垂管系统id",//国家垂管系统整合时时候（非必填）"sourceData":?"原始数据"//国家垂管系统库表交换原始数据（非必填）} */
    @Excel(name = "扩展字段", readConverterExp = "非=必填")
    private String formInfos;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String record;

    /** 是否拉取至仲裁系统 */
    @Excel(name = "是否拉取至仲裁系统")
    private Long isReflux;

    public void setProvincePullDataAuditId(String provincePullDataAuditId) 
    {
        this.provincePullDataAuditId = provincePullDataAuditId;
    }

    public String getProvincePullDataAuditId() 
    {
        return provincePullDataAuditId;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }
    public void setFromCode(String fromCode) 
    {
        this.fromCode = fromCode;
    }

    public String getFromCode() 
    {
        return fromCode;
    }
    public void setWsspXml(String wsspXml) 
    {
        this.wsspXml = wsspXml;
    }

    public String getWsspXml() 
    {
        return wsspXml;
    }
    public void setNextXml(String nextXml) 
    {
        this.nextXml = nextXml;
    }

    public String getNextXml() 
    {
        return nextXml;
    }
    public void setSuspendXml(String suspendXml) 
    {
        this.suspendXml = suspendXml;
    }

    public String getSuspendXml() 
    {
        return suspendXml;
    }
    public void setResumeXml(String resumeXml) 
    {
        this.resumeXml = resumeXml;
    }

    public String getResumeXml() 
    {
        return resumeXml;
    }
    public void setFinishXml(String finishXml) 
    {
        this.finishXml = finishXml;
    }

    public String getFinishXml() 
    {
        return finishXml;
    }
    public void setExpressXml(String expressXml) 
    {
        this.expressXml = expressXml;
    }

    public String getExpressXml() 
    {
        return expressXml;
    }
    public void setAuditTimestamp(String auditTimestamp) 
    {
        this.auditTimestamp = auditTimestamp;
    }

    public String getAuditTimestamp() 
    {
        return auditTimestamp;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }
    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }
    public void setCreatedUserId(String createdUserId) 
    {
        this.createdUserId = createdUserId;
    }

    public String getCreatedUserId() 
    {
        return createdUserId;
    }
    public void setUpdatedUserId(String updatedUserId) 
    {
        this.updatedUserId = updatedUserId;
    }

    public String getUpdatedUserId() 
    {
        return updatedUserId;
    }
    public void setFormInfos(String formInfos) 
    {
        this.formInfos = formInfos;
    }

    public String getFormInfos() 
    {
        return formInfos;
    }
    public void setRecord(String record) 
    {
        this.record = record;
    }

    public String getRecord() 
    {
        return record;
    }
    public void setIsReflux(Long isReflux) 
    {
        this.isReflux = isReflux;
    }

    public Long getIsReflux() 
    {
        return isReflux;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("provincePullDataAuditId", getProvincePullDataAuditId())
            .append("sn", getSn())
            .append("fromCode", getFromCode())
            .append("wsspXml", getWsspXml())
            .append("nextXml", getNextXml())
            .append("suspendXml", getSuspendXml())
            .append("resumeXml", getResumeXml())
            .append("finishXml", getFinishXml())
            .append("expressXml", getExpressXml())
            .append("auditTimestamp", getAuditTimestamp())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .append("version", getVersion())
            .append("createdUserId", getCreatedUserId())
            .append("updatedUserId", getUpdatedUserId())
            .append("formInfos", getFormInfos())
            .append("record", getRecord())
            .append("isReflux", getIsReflux())
            .toString();
    }
}
