package com.tch.system.service.impl;

import java.util.List;

import com.tch.system.service.IYthTGaShlbjxxInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tch.system.mapper.YthTGaShlbjxxInfoMapper;
import com.tch.system.domain.YthTGaShlbjxxInfo;
import com.tch.common.core.text.Convert;

/**
 * caseUploadService业务层处理
 * 
 * @author Wythe
 * @date 2024-03-17
 */
@Service
public class YthTGaShlbjxxInfoServiceImpl implements IYthTGaShlbjxxInfoService
{
    @Autowired
    private YthTGaShlbjxxInfoMapper ythTGaShlbjxxInfoMapper;

    /**
     * 查询caseUpload
     * 
     * @param provincePullDataAuditId caseUpload主键
     * @return caseUpload
     */
    @Override
    public YthTGaShlbjxxInfo selectYthTGaShlbjxxInfoByProvincePullDataAuditId(String provincePullDataAuditId)
    {
        return ythTGaShlbjxxInfoMapper.selectYthTGaShlbjxxInfoByProvincePullDataAuditId(provincePullDataAuditId);
    }

    /**
     * 查询caseUpload列表
     * 
     * @param ythTGaShlbjxxInfo caseUpload
     * @return caseUpload
     */
    @Override
    public List<YthTGaShlbjxxInfo> selectYthTGaShlbjxxInfoList(YthTGaShlbjxxInfo ythTGaShlbjxxInfo)
    {
        return ythTGaShlbjxxInfoMapper.selectYthTGaShlbjxxInfoList(ythTGaShlbjxxInfo);
    }

    /**
     * 新增caseUpload
     * 
     * @param ythTGaShlbjxxInfo caseUpload
     * @return 结果
     */
    @Override
    public int insertYthTGaShlbjxxInfo(YthTGaShlbjxxInfo ythTGaShlbjxxInfo)
    {
        return ythTGaShlbjxxInfoMapper.insertYthTGaShlbjxxInfo(ythTGaShlbjxxInfo);
    }

    /**
     * 修改caseUpload
     * 
     * @param ythTGaShlbjxxInfo caseUpload
     * @return 结果
     */
    @Override
    public int updateYthTGaShlbjxxInfo(YthTGaShlbjxxInfo ythTGaShlbjxxInfo)
    {
        return ythTGaShlbjxxInfoMapper.updateYthTGaShlbjxxInfo(ythTGaShlbjxxInfo);
    }

    /**
     * 批量删除caseUpload
     * 
     * @param provincePullDataAuditIds 需要删除的caseUpload主键
     * @return 结果
     */
    @Override
    public int deleteYthTGaShlbjxxInfoByProvincePullDataAuditIds(String provincePullDataAuditIds)
    {
        return ythTGaShlbjxxInfoMapper.deleteYthTGaShlbjxxInfoByProvincePullDataAuditIds(Convert.toStrArray(provincePullDataAuditIds));
    }

    /**
     * 删除caseUpload信息
     * 
     * @param provincePullDataAuditId caseUpload主键
     * @return 结果
     */
    @Override
    public int deleteYthTGaShlbjxxInfoByProvincePullDataAuditId(String provincePullDataAuditId)
    {
        return ythTGaShlbjxxInfoMapper.deleteYthTGaShlbjxxInfoByProvincePullDataAuditId(provincePullDataAuditId);
    }
}
