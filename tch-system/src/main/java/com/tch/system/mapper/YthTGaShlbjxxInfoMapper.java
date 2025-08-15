package com.tch.system.mapper;

import java.util.List;
import com.tch.system.domain.YthTGaShlbjxxInfo;

/**
 * caseUploadMapper接口
 * 
 * @author Wythe
 * @date 2024-03-17
 */
public interface YthTGaShlbjxxInfoMapper 
{
    /**
     * 查询caseUpload
     * 
     * @param provincePullDataAuditId caseUpload主键
     * @return caseUpload
     */
    public YthTGaShlbjxxInfo selectYthTGaShlbjxxInfoByProvincePullDataAuditId(String provincePullDataAuditId);



    public List<YthTGaShlbjxxInfo> selectYthTGaShlbjxxStartTimeToEndTime(String provincePullDataAuditId);
    /**
     * 查询caseUpload列表
     * 
     * @param ythTGaShlbjxxInfo caseUpload
     * @return caseUpload集合
     */
    public List<YthTGaShlbjxxInfo> selectYthTGaShlbjxxInfoList(YthTGaShlbjxxInfo ythTGaShlbjxxInfo);

    /**
     * 新增caseUpload
     * 
     * @param ythTGaShlbjxxInfo caseUpload
     * @return 结果
     */
    public int insertYthTGaShlbjxxInfo(YthTGaShlbjxxInfo ythTGaShlbjxxInfo);

    /**
     * 修改caseUpload
     * 
     * @param ythTGaShlbjxxInfo caseUpload
     * @return 结果
     */
    public int updateYthTGaShlbjxxInfo(YthTGaShlbjxxInfo ythTGaShlbjxxInfo);

    /**
     * 删除caseUpload
     * 
     * @param provincePullDataAuditId caseUpload主键
     * @return 结果
     */
    public int deleteYthTGaShlbjxxInfoByProvincePullDataAuditId(String provincePullDataAuditId);

    /**
     * 批量删除caseUpload
     * 
     * @param provincePullDataAuditIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYthTGaShlbjxxInfoByProvincePullDataAuditIds(String[] provincePullDataAuditIds);

    public List<YthTGaShlbjxxInfo> selectYthTGaShlbjxxVersion(String provincePullDataAuditId);
}
