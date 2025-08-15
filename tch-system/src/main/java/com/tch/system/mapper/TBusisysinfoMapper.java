package com.tch.system.mapper;


import com.tch.system.domain.TBusisysinfo;

import java.util.List;

/**
 * 业务系统推送到共享平台的业务数据Mapper接口
 * 
 * @author wythe
 * @date 2024-03-18
 */
public interface TBusisysinfoMapper 
{
    /**
     * 查询业务系统推送到共享平台的业务数据
     * 
     * @param unid 业务系统推送到共享平台的业务数据主键
     * @return 业务系统推送到共享平台的业务数据
     */
    public TBusisysinfo selectTBusisysinfoByUnid(String unid);

    /**
     * 查询业务系统推送到共享平台的业务数据列表
     * 
     * @param tBusisysinfo 业务系统推送到共享平台的业务数据
     * @return 业务系统推送到共享平台的业务数据集合
     */
    public List<TBusisysinfo> selectTBusisysinfoList(TBusisysinfo tBusisysinfo);

    /**
     * 新增业务系统推送到共享平台的业务数据
     * 
     * @param tBusisysinfo 业务系统推送到共享平台的业务数据
     * @return 结果
     */
    public int insertTBusisysinfo(TBusisysinfo tBusisysinfo);

    /**
     * 修改业务系统推送到共享平台的业务数据
     * 
     * @param tBusisysinfo 业务系统推送到共享平台的业务数据
     * @return 结果
     */
    public int updateTBusisysinfo(TBusisysinfo tBusisysinfo);



    public int updateTBusisysinfoByIdList(List<TBusisysinfo> tBusisysinfoList);

    /**
     * 删除业务系统推送到共享平台的业务数据
     * 
     * @param unid 业务系统推送到共享平台的业务数据主键
     * @return 结果
     */
    public int deleteTBusisysinfoByUnid(String unid);

    /**
     * 批量删除业务系统推送到共享平台的业务数据
     * 
     * @param unids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBusisysinfoByUnids(String[] unids);

    /**批量查询出数据
     * 定时任务查询
     * @return 结果
     */
    List<TBusisysinfo> selectTBusisysinfoDataList();



    public List<TBusisysinfo> selectTBusisysinfoByType(String type);
}
