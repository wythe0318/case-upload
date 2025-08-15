package com.tch.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tch.common.annotation.Excel;
import com.tch.common.core.domain.BaseEntity;

/**
 * 事项基本信息对象 dn_task_basic
 *
 * @author wythe
 * @date 2024-03-26
 */
public class DnTaskBasic extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 记录唯一标识
     */
    @Excel(name = "记录唯一标识")
    private String rowGuid;

    /**
     * 事项名称
     */
    @Excel(name = "事项名称")
    private String taskName;

    /**
     * 基本编码
     */
    @Excel(name = "基本编码")
    private String catalogCode;

    /**
     * 地方基本编码，暂时取消必填
     */
    @Excel(name = "地方基本编码，暂时取消必填")
    private String localCatalogCode;

    /**
     * 事项类型
     */
    @Excel(name = "事项类型")
    private String taskType;

    /**
     * 设定依据
     */
    @Excel(name = "设定依据")
    private String byLaw;

    /**
     * 权力来源，暂时取消必填
     */
    @Excel(name = "权力来源，暂时取消必填")
    private String powerSource;

    /**
     * 行使层级
     */
    @Excel(name = "行使层级")
    private String useLevel;

    /**
     * 实施编码
     */
    @Excel(name = "实施编码")
    private String taskCode;

    /**
     * 地方实施编码
     */
    @Excel(name = "地方实施编码")
    private String localTaskCode;

    /**
     * 业务办理项编码
     */
    @Excel(name = "业务办理项编码")
    private String taskHandleItem;

    /**
     * 事项状态
     */
    @Excel(name = "事项状态")
    private String taskState;

    /**
     * 事项版本
     */
    @Excel(name = "事项版本")
    private Long taskVersion;

    /**
     * 实施主体
     */
    @Excel(name = "实施主体")
    private String deptName;

    /**
     * 实施主体性质
     */
    @Excel(name = "实施主体性质")
    private String deptType;

    /**
     * 实施主体编码
     */
    @Excel(name = "实施主体编码")
    private String deptCode;

    /**
     * 委托部门
     */
    @Excel(name = "委托部门")
    private String entrustName;

    /**
     * 法定办结时限
     */
    @Excel(name = "法定办结时限")
    private Long anticipateDay;

    /**
     * 法定办结期限单位
     */
    @Excel(name = "法定办结期限单位")
    private String anticipateType;

    /**
     * 法定办结时限说明
     */
    @Excel(name = "法定办结时限说明")
    private String anticipateExplain;

    /**
     * 承诺办结时限
     */
    @Excel(name = "承诺办结时限")
    private Long promiseDay;

    /**
     * 承诺办结期限单位
     */
    @Excel(name = "承诺办结期限单位")
    private String promiseType;

    /**
     * 承诺办结时限说明
     */
    @Excel(name = "承诺办结时限说明")
    private String promiseExplain;

    /**
     * 受理条件
     */
    @Excel(name = "受理条件")
    private String acceptCondition;

    /**
     * 办理流程，暂时取消必填
     */
    @Excel(name = "办理流程，暂时取消必填")
    private String handleFlow;

    /**
     * 是否收费
     */
    @Excel(name = "是否收费")
    private String isFee;

    /**
     * 收费依据
     */
    @Excel(name = "收费依据")
    private String feeBasis;

    /**
     * 服务对象
     */
    @Excel(name = "服务对象")
    private String serverType;

    /**
     * 办件类型
     */
    @Excel(name = "办件类型")
    private String projectType;

    /**
     * 办理形式
     */
    @Excel(name = "办理形式")
    private String handleType;

    /**
     * 到办事现场次数
     */
    @Excel(name = "到办事现场次数")
    private Long limitSceneNum;

    /**
     * 特别程序
     */
    @Excel(name = "特别程序")
    private String specialProcedure;

    /**
     * 移动端是否对接单点登录
     */
    @Excel(name = "移动端是否对接单点登录")
    private String appIsSingleLogin;

    /**
     * 移动端办理地址
     */
    @Excel(name = "移动端办理地址")
    private String mobileTerminalUrl;

    /**
     * 计算机端是否对接单点登录
     */
    @Excel(name = "计算机端是否对接单点登录")
    private String isSingleLogin;

    /**
     * 电脑端在线办理跳转地址
     */
    @Excel(name = "电脑端在线办理跳转地址")
    private String linkAddr;

    /**
     * 办理地点，暂时取消必填
     */
    @Excel(name = "办理地点，暂时取消必填")
    private String transactAddr;

    /**
     * 办理时间
     */
    @Excel(name = "办理时间")
    private String transactTime;

    /**
     * 咨询方式
     */
    @Excel(name = "咨询方式")
    private String linkWay;

    /**
     * 监督投诉方式
     */
    @Excel(name = "监督投诉方式")
    private String superviseWay;

    /**
     * 计划生效日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划生效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planEffectiveDate;

    /**
     * 计划取消日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划取消日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planCancelDate;

    /**
     * 创建单位
     */
    @Excel(name = "创建单位")
    private String cjdw;

    /**
     * 更新单位
     */
    @Excel(name = "更新单位")
    private String gxdw;

    /**
     * 同步批次号
     */
    @Excel(name = "同步批次号")
    private String cdBatch;

    /**
     * 同步类型
     */
    @Excel(name = "同步类型")
    private String cdOperation;

    /**
     * 同步时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "同步时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cdTime;

    /**
     * 同步来源
     */
    @Excel(name = "同步来源")
    private String dataSource;

    /**
     * 打包标识
     */
    @Excel(name = "打包标识")
    private String dbbs;

    /**
     * 打包时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "打包时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dbsj;

    /**
     * 用于签名的Ca证书（防篡改）
     */
    @Excel(name = "用于签名的Ca证书", readConverterExp = "防=篡改")
    private String signCa;

    /**
     * 完整性签名信息
     */
    @Excel(name = "完整性签名信息")
    private String signData;

    /**
     * 系统编码
     */
    @Excel(name = "系统编码")
    private String systemNo;

    /**
     * 办件配置类型 0-统一配置 1-自行配置
     */
    @Excel(name = "办件配置类型 0-统一配置 1-自行配置")
    private String handleConifgType;

    /**
     * 采集项配置类型 0-统一配置 1-自行配置
     */
    @Excel(name = "采集项配置类型 0-统一配置 1-自行配置")
    private String fieldConfigType;

    /**
     * 流程配置 0-统一配置  1-自行配置
     */
    @Excel(name = "流程配置 0-统一配置  1-自行配置")
    private String flowConfigType;

    /**
     * 单位配置 0.统一配置 1-自行配置
     */
    @Excel(name = "单位配置 0.统一配置 1-自行配置")
    private String orgConfigType;

    private String code;

    private String serviceId;

    private String regionCode;

    private String olditemId;

    private String itemId;

    private  String assort;//办件类型

    public String getAssort() {
        return assort;
    }

    public void setAssort(String assort) {
        this.assort = assort;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getOlditemId() {
        return olditemId;
    }

    public void setOlditemId(String olditemId) {
        this.olditemId = olditemId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRowGuid(String rowGuid) {
        this.rowGuid = rowGuid;
    }

    public String getRowGuid() {
        return rowGuid;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setLocalCatalogCode(String localCatalogCode) {
        this.localCatalogCode = localCatalogCode;
    }

    public String getLocalCatalogCode() {
        return localCatalogCode;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setByLaw(String byLaw) {
        this.byLaw = byLaw;
    }

    public String getByLaw() {
        return byLaw;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    public String getPowerSource() {
        return powerSource;
    }

    public void setUseLevel(String useLevel) {
        this.useLevel = useLevel;
    }

    public String getUseLevel() {
        return useLevel;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setLocalTaskCode(String localTaskCode) {
        this.localTaskCode = localTaskCode;
    }

    public String getLocalTaskCode() {
        return localTaskCode;
    }

    public void setTaskHandleItem(String taskHandleItem) {
        this.taskHandleItem = taskHandleItem;
    }

    public String getTaskHandleItem() {
        return taskHandleItem;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskVersion(Long taskVersion) {
        this.taskVersion = taskVersion;
    }

    public Long getTaskVersion() {
        return taskVersion;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setEntrustName(String entrustName) {
        this.entrustName = entrustName;
    }

    public String getEntrustName() {
        return entrustName;
    }

    public void setAnticipateDay(Long anticipateDay) {
        this.anticipateDay = anticipateDay;
    }

    public Long getAnticipateDay() {
        return anticipateDay;
    }

    public void setAnticipateType(String anticipateType) {
        this.anticipateType = anticipateType;
    }

    public String getAnticipateType() {
        return anticipateType;
    }

    public void setAnticipateExplain(String anticipateExplain) {
        this.anticipateExplain = anticipateExplain;
    }

    public String getAnticipateExplain() {
        return anticipateExplain;
    }

    public void setPromiseDay(Long promiseDay) {
        this.promiseDay = promiseDay;
    }

    public Long getPromiseDay() {
        return promiseDay;
    }

    public void setPromiseType(String promiseType) {
        this.promiseType = promiseType;
    }

    public String getPromiseType() {
        return promiseType;
    }

    public void setPromiseExplain(String promiseExplain) {
        this.promiseExplain = promiseExplain;
    }

    public String getPromiseExplain() {
        return promiseExplain;
    }

    public void setAcceptCondition(String acceptCondition) {
        this.acceptCondition = acceptCondition;
    }

    public String getAcceptCondition() {
        return acceptCondition;
    }

    public void setHandleFlow(String handleFlow) {
        this.handleFlow = handleFlow;
    }

    public String getHandleFlow() {
        return handleFlow;
    }

    public void setIsFee(String isFee) {
        this.isFee = isFee;
    }

    public String getIsFee() {
        return isFee;
    }

    public void setFeeBasis(String feeBasis) {
        this.feeBasis = feeBasis;
    }

    public String getFeeBasis() {
        return feeBasis;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getServerType() {
        return serverType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setLimitSceneNum(Long limitSceneNum) {
        this.limitSceneNum = limitSceneNum;
    }

    public Long getLimitSceneNum() {
        return limitSceneNum;
    }

    public void setSpecialProcedure(String specialProcedure) {
        this.specialProcedure = specialProcedure;
    }

    public String getSpecialProcedure() {
        return specialProcedure;
    }

    public void setAppIsSingleLogin(String appIsSingleLogin) {
        this.appIsSingleLogin = appIsSingleLogin;
    }

    public String getAppIsSingleLogin() {
        return appIsSingleLogin;
    }

    public void setMobileTerminalUrl(String mobileTerminalUrl) {
        this.mobileTerminalUrl = mobileTerminalUrl;
    }

    public String getMobileTerminalUrl() {
        return mobileTerminalUrl;
    }

    public void setIsSingleLogin(String isSingleLogin) {
        this.isSingleLogin = isSingleLogin;
    }

    public String getIsSingleLogin() {
        return isSingleLogin;
    }

    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr;
    }

    public String getLinkAddr() {
        return linkAddr;
    }

    public void setTransactAddr(String transactAddr) {
        this.transactAddr = transactAddr;
    }

    public String getTransactAddr() {
        return transactAddr;
    }

    public void setTransactTime(String transactTime) {
        this.transactTime = transactTime;
    }

    public String getTransactTime() {
        return transactTime;
    }

    public void setLinkWay(String linkWay) {
        this.linkWay = linkWay;
    }

    public String getLinkWay() {
        return linkWay;
    }

    public void setSuperviseWay(String superviseWay) {
        this.superviseWay = superviseWay;
    }

    public String getSuperviseWay() {
        return superviseWay;
    }

    public void setPlanEffectiveDate(Date planEffectiveDate) {
        this.planEffectiveDate = planEffectiveDate;
    }

    public Date getPlanEffectiveDate() {
        return planEffectiveDate;
    }

    public void setPlanCancelDate(Date planCancelDate) {
        this.planCancelDate = planCancelDate;
    }

    public Date getPlanCancelDate() {
        return planCancelDate;
    }

    public void setCjdw(String cjdw) {
        this.cjdw = cjdw;
    }

    public String getCjdw() {
        return cjdw;
    }

    public void setGxdw(String gxdw) {
        this.gxdw = gxdw;
    }

    public String getGxdw() {
        return gxdw;
    }

    public void setCdBatch(String cdBatch) {
        this.cdBatch = cdBatch;
    }

    public String getCdBatch() {
        return cdBatch;
    }

    public void setCdOperation(String cdOperation) {
        this.cdOperation = cdOperation;
    }

    public String getCdOperation() {
        return cdOperation;
    }

    public void setCdTime(Date cdTime) {
        this.cdTime = cdTime;
    }

    public Date getCdTime() {
        return cdTime;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDbbs(String dbbs) {
        this.dbbs = dbbs;
    }

    public String getDbbs() {
        return dbbs;
    }

    public void setDbsj(Date dbsj) {
        this.dbsj = dbsj;
    }

    public Date getDbsj() {
        return dbsj;
    }

    public void setSignCa(String signCa) {
        this.signCa = signCa;
    }

    public String getSignCa() {
        return signCa;
    }

    public void setSignData(String signData) {
        this.signData = signData;
    }

    public String getSignData() {
        return signData;
    }

    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo;
    }

    public String getSystemNo() {
        return systemNo;
    }

    public void setHandleConifgType(String handleConifgType) {
        this.handleConifgType = handleConifgType;
    }

    public String getHandleConifgType() {
        return handleConifgType;
    }

    public void setFieldConfigType(String fieldConfigType) {
        this.fieldConfigType = fieldConfigType;
    }

    public String getFieldConfigType() {
        return fieldConfigType;
    }

    public void setFlowConfigType(String flowConfigType) {
        this.flowConfigType = flowConfigType;
    }

    public String getFlowConfigType() {
        return flowConfigType;
    }

    public void setOrgConfigType(String orgConfigType) {
        this.orgConfigType = orgConfigType;
    }

    public String getOrgConfigType() {
        return orgConfigType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("rowGuid", getRowGuid())
                .append("taskName", getTaskName())
                .append("catalogCode", getCatalogCode())
                .append("localCatalogCode", getLocalCatalogCode())
                .append("taskType", getTaskType())
                .append("byLaw", getByLaw())
                .append("powerSource", getPowerSource())
                .append("useLevel", getUseLevel())
                .append("taskCode", getTaskCode())
                .append("localTaskCode", getLocalTaskCode())
                .append("taskHandleItem", getTaskHandleItem())
                .append("taskState", getTaskState())
                .append("taskVersion", getTaskVersion())
                .append("deptName", getDeptName())
                .append("deptType", getDeptType())
                .append("deptCode", getDeptCode())
                .append("entrustName", getEntrustName())
                .append("anticipateDay", getAnticipateDay())
                .append("anticipateType", getAnticipateType())
                .append("anticipateExplain", getAnticipateExplain())
                .append("promiseDay", getPromiseDay())
                .append("promiseType", getPromiseType())
                .append("promiseExplain", getPromiseExplain())
                .append("acceptCondition", getAcceptCondition())
                .append("handleFlow", getHandleFlow())
                .append("isFee", getIsFee())
                .append("feeBasis", getFeeBasis())
                .append("serverType", getServerType())
                .append("projectType", getProjectType())
                .append("handleType", getHandleType())
                .append("limitSceneNum", getLimitSceneNum())
                .append("specialProcedure", getSpecialProcedure())
                .append("appIsSingleLogin", getAppIsSingleLogin())
                .append("mobileTerminalUrl", getMobileTerminalUrl())
                .append("isSingleLogin", getIsSingleLogin())
                .append("linkAddr", getLinkAddr())
                .append("transactAddr", getTransactAddr())
                .append("transactTime", getTransactTime())
                .append("linkWay", getLinkWay())
                .append("superviseWay", getSuperviseWay())
                .append("planEffectiveDate", getPlanEffectiveDate())
                .append("planCancelDate", getPlanCancelDate())
                .append("updateTime", getUpdateTime())
                .append("createTime", getCreateTime())
                .append("cjdw", getCjdw())
                .append("gxdw", getGxdw())
                .append("cdBatch", getCdBatch())
                .append("cdOperation", getCdOperation())
                .append("cdTime", getCdTime())
                .append("dataSource", getDataSource())
                .append("dbbs", getDbbs())
                .append("dbsj", getDbsj())
                .append("signCa", getSignCa())
                .append("signData", getSignData())
                .append("systemNo", getSystemNo())
                .append("handleConifgType", getHandleConifgType())
                .append("fieldConfigType", getFieldConfigType())
                .append("flowConfigType", getFlowConfigType())
                .append("orgConfigType", getOrgConfigType())
                .append("code", getCode())
                .append("serviceId", getServiceId())
                .append("regionCode", getRegionCode())
                .append("olditemId",getOlditemId())
                .append("itemId",getItemId())
                .toString();
    }
}
