package com.tch.system.mapper;

import java.util.List;
import com.tch.system.domain.DnTaskBasic;
import org.apache.ibatis.annotations.Param;

/**
 * 事项信息Mapper接口
 * 
 * @author wythe
 * @date 2024-03-26
 */
public interface DnTaskBasicMapper 
{
    /**
     * 查询事项信息
     * 
     * @param id 事项信息主键
     * @return 事项信息
     */
    public DnTaskBasic selectDnTaskBasicById(Long id);


    public DnTaskBasic selectDnTaskBasicByCode(@Param("code") String code);

    /**
     * 查询事项信息列表
     * 
     * @param dnTaskBasic 事项信息
     * @return 事项信息集合
     */
    public List<DnTaskBasic> selectDnTaskBasicList(DnTaskBasic dnTaskBasic);

    /**
     * 新增事项信息
     * 
     * @param dnTaskBasic 事项信息
     * @return 结果
     */
    public int insertDnTaskBasic(DnTaskBasic dnTaskBasic);

    /**
     * 修改事项信息
     * 
     * @param dnTaskBasic 事项信息
     * @return 结果
     */
    public int updateDnTaskBasic(DnTaskBasic dnTaskBasic);

    /**
     * 删除事项信息
     * 
     * @param id 事项信息主键
     * @return 结果
     */
    public int deleteDnTaskBasicById(Long id);

    /**
     * 批量删除事项信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDnTaskBasicByIds(String[] ids);

    DnTaskBasic getByRowGuId(@Param("rowGuid") String rowGuid);
}
