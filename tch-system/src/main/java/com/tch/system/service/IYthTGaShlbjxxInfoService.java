package com.tch.system.service;

import java.util.List;
import com.tch.system.domain.YthTGaShlbjxxInfo;

/**
 * caseUploadService接口
 * 
 * @author Wythe
 * @date 2024-03-17
 */
public interface IYthTGaShlbjxxInfoService 
{
    /**
     * 查询caseUpload
     * 
     * @param provincePullDataAuditId caseUpload主键
     * @return caseUpload
     */
    public YthTGaShlbjxxInfo selectYthTGaShlbjxxInfoByProvincePullDataAuditId(String provincePullDataAuditId);

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
     * 批量删除caseUpload
     * 
     * @param provincePullDataAuditIds 需要删除的caseUpload主键集合
     * @return 结果
     */
    public int deleteYthTGaShlbjxxInfoByProvincePullDataAuditIds(String provincePullDataAuditIds);

    /**
     * 删除caseUpload信息
     * 
     * @param provincePullDataAuditId caseUpload主键
     * @return 结果
     */
    public int deleteYthTGaShlbjxxInfoByProvincePullDataAuditId(String provincePullDataAuditId);
}
