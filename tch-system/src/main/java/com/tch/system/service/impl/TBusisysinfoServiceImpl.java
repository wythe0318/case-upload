package com.tch.system.service.impl;

import com.tch.common.core.text.Convert;
import com.tch.system.domain.TBusisysinfo;
import com.tch.system.mapper.TBusisysinfoMapper;
import com.tch.system.service.ITBusisysinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务系统推送到共享平台的业务数据Service业务层处理
 * 
 * @author wythe
 * @date 2024-03-18
 */
@Service
public class TBusisysinfoServiceImpl implements ITBusisysinfoService
{
    @Autowired
    private TBusisysinfoMapper tBusisysinfoMapper;

    /**
     * 查询业务系统推送到共享平台的业务数据
     * 
     * @param unid 业务系统推送到共享平台的业务数据主键
     * @return 业务系统推送到共享平台的业务数据
     */
    @Override
    public TBusisysinfo selectTBusisysinfoByUnid(String unid)
    {
        return tBusisysinfoMapper.selectTBusisysinfoByUnid(unid);
    }

    /**
     * 查询业务系统推送到共享平台的业务数据列表
     * 
     * @param tBusisysinfo 业务系统推送到共享平台的业务数据
     * @return 业务系统推送到共享平台的业务数据
     */
    @Override
    public List<TBusisysinfo> selectTBusisysinfoList(TBusisysinfo tBusisysinfo)
    {
        return tBusisysinfoMapper.selectTBusisysinfoList(tBusisysinfo);
    }

    /**
     * 新增业务系统推送到共享平台的业务数据
     * 
     * @param tBusisysinfo 业务系统推送到共享平台的业务数据
     * @return 结果
     */
    @Override
    public int insertTBusisysinfo(TBusisysinfo tBusisysinfo)
    {
        return tBusisysinfoMapper.insertTBusisysinfo(tBusisysinfo);
    }

    /**
     * 修改业务系统推送到共享平台的业务数据
     * 
     * @param tBusisysinfo 业务系统推送到共享平台的业务数据
     * @return 结果
     */
    @Override
    public int updateTBusisysinfo(TBusisysinfo tBusisysinfo)
    {
        return tBusisysinfoMapper.updateTBusisysinfo(tBusisysinfo);
    }

    /**
     * 批量删除业务系统推送到共享平台的业务数据
     * 
     * @param unids 需要删除的业务系统推送到共享平台的业务数据主键
     * @return 结果
     */
    @Override
    public int deleteTBusisysinfoByUnids(String unids)
    {
        return tBusisysinfoMapper.deleteTBusisysinfoByUnids(Convert.toStrArray(unids));
    }

    /**
     * 删除业务系统推送到共享平台的业务数据信息
     * 
     * @param unid 业务系统推送到共享平台的业务数据主键
     * @return 结果
     */
    @Override
    public int deleteTBusisysinfoByUnid(String unid)
    {
        return tBusisysinfoMapper.deleteTBusisysinfoByUnid(unid);
    }
}
