package com.tch.system.service.impl;

import java.util.List;
import com.tch.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tch.system.mapper.DnTaskBasicMapper;
import com.tch.system.domain.DnTaskBasic;
import com.tch.system.service.IDnTaskBasicService;
import com.tch.common.core.text.Convert;

/**
 * 事项基本信息Service业务层处理
 * 
 * @author wythe
 * @date 2024-03-26
 */
@Service
public class DnTaskBasicServiceImpl implements IDnTaskBasicService 
{
    @Autowired
    private DnTaskBasicMapper dnTaskBasicMapper;

    /**
     * 查询事项基本信息
     * 
     * @param id 事项基本信息主键
     * @return 事项基本信息
     */
    @Override
    public DnTaskBasic selectDnTaskBasicById(Long id)
    {
        return dnTaskBasicMapper.selectDnTaskBasicById(id);
    }

    /**
     * 查询事项基本信息列表
     * 
     * @param dnTaskBasic 事项基本信息
     * @return 事项基本信息
     */
    @Override
    public List<DnTaskBasic> selectDnTaskBasicList(DnTaskBasic dnTaskBasic)
    {
        return dnTaskBasicMapper.selectDnTaskBasicList(dnTaskBasic);
    }

    /**
     * 新增事项基本信息
     * 
     * @param dnTaskBasic 事项基本信息
     * @return 结果
     */
    @Override
    public int insertDnTaskBasic(DnTaskBasic dnTaskBasic)
    {
        dnTaskBasic.setCreateTime(DateUtils.getNowDate());
        return dnTaskBasicMapper.insertDnTaskBasic(dnTaskBasic);
    }

    /**
     * 修改事项基本信息
     * 
     * @param dnTaskBasic 事项基本信息
     * @return 结果
     */
    @Override
    public int updateDnTaskBasic(DnTaskBasic dnTaskBasic)
    {
        dnTaskBasic.setUpdateTime(DateUtils.getNowDate());
        return dnTaskBasicMapper.updateDnTaskBasic(dnTaskBasic);
    }

    /**
     * 批量删除事项基本信息
     * 
     * @param ids 需要删除的事项基本信息主键
     * @return 结果
     */
    @Override
    public int deleteDnTaskBasicByIds(String ids)
    {
        return dnTaskBasicMapper.deleteDnTaskBasicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除事项基本信息信息
     * 
     * @param id 事项基本信息主键
     * @return 结果
     */
    @Override
    public int deleteDnTaskBasicById(Long id)
    {
        return dnTaskBasicMapper.deleteDnTaskBasicById(id);
    }
}
