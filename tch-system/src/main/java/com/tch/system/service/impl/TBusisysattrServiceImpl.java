package com.tch.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tch.system.mapper.TBusisysattrMapper;
import com.tch.system.domain.TBusisysattr;
import com.tch.system.service.ITBusisysattrService;
import com.tch.common.core.text.Convert;

/**
 * 业务附件Service业务层处理
 * 
 * @author wythe
 * @date 2024-03-18
 */
@Service
public class TBusisysattrServiceImpl implements ITBusisysattrService 
{
    @Autowired
    private TBusisysattrMapper tBusisysattrMapper;

    /**
     * 查询业务附件
     * 
     * @param unid 业务附件主键
     * @return 业务附件
     */
    @Override
    public TBusisysattr selectTBusisysattrByUnid(String unid)
    {
        return tBusisysattrMapper.selectTBusisysattrByUnid(unid);
    }

    /**
     * 查询业务附件列表
     * 
     * @param tBusisysattr 业务附件
     * @return 业务附件
     */
    @Override
    public List<TBusisysattr> selectTBusisysattrList(TBusisysattr tBusisysattr)
    {
        return tBusisysattrMapper.selectTBusisysattrList(tBusisysattr);
    }

    /**
     * 新增业务附件
     * 
     * @param tBusisysattr 业务附件
     * @return 结果
     */
    @Override
    public int insertTBusisysattr(TBusisysattr tBusisysattr)
    {
        return tBusisysattrMapper.insertTBusisysattr(tBusisysattr);
    }

    /**
     * 修改业务附件
     * 
     * @param tBusisysattr 业务附件
     * @return 结果
     */
    @Override
    public int updateTBusisysattr(TBusisysattr tBusisysattr)
    {
        return tBusisysattrMapper.updateTBusisysattr(tBusisysattr);
    }

    /**
     * 批量删除业务附件
     * 
     * @param unids 需要删除的业务附件主键
     * @return 结果
     */
    @Override
    public int deleteTBusisysattrByUnids(String unids)
    {
        return tBusisysattrMapper.deleteTBusisysattrByUnids(Convert.toStrArray(unids));
    }

    /**
     * 删除业务附件信息
     * 
     * @param unid 业务附件主键
     * @return 结果
     */
    @Override
    public int deleteTBusisysattrByUnid(String unid)
    {
        return tBusisysattrMapper.deleteTBusisysattrByUnid(unid);
    }
}
