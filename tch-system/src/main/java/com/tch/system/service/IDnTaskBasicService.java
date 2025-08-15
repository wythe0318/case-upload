package com.tch.system.service;

import java.util.List;
import com.tch.system.domain.DnTaskBasic;

/**
 * 事项基本信息Service接口
 * 
 * @author wythe
 * @date 2024-03-26
 */
public interface IDnTaskBasicService 
{
    /**
     * 查询事项基本信息
     * 
     * @param id 事项基本信息主键
     * @return 事项基本信息
     */
    public DnTaskBasic selectDnTaskBasicById(Long id);

    /**
     * 查询事项基本信息列表
     * 
     * @param dnTaskBasic 事项基本信息
     * @return 事项基本信息集合
     */
    public List<DnTaskBasic> selectDnTaskBasicList(DnTaskBasic dnTaskBasic);

    /**
     * 新增事项基本信息
     * 
     * @param dnTaskBasic 事项基本信息
     * @return 结果
     */
    public int insertDnTaskBasic(DnTaskBasic dnTaskBasic);

    /**
     * 修改事项基本信息
     * 
     * @param dnTaskBasic 事项基本信息
     * @return 结果
     */
    public int updateDnTaskBasic(DnTaskBasic dnTaskBasic);

    /**
     * 批量删除事项基本信息
     * 
     * @param ids 需要删除的事项基本信息主键集合
     * @return 结果
     */
    public int deleteDnTaskBasicByIds(String ids);

    /**
     * 删除事项基本信息信息
     * 
     * @param id 事项基本信息主键
     * @return 结果
     */
    public int deleteDnTaskBasicById(Long id);
}
