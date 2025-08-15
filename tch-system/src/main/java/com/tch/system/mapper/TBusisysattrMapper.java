package com.tch.system.mapper;

import java.util.List;
import com.tch.system.domain.TBusisysattr;

/**
 * 业务附件Mapper接口
 * 
 * @author wythe
 * @date 2024-03-18
 */
public interface TBusisysattrMapper 
{
    /**
     * 查询业务附件
     * 
     * @param unid 业务附件主键
     * @return 业务附件
     */
    public TBusisysattr selectTBusisysattrByUnid(String unid);

    /**
     * 查询业务附件列表
     * 
     * @param tBusisysattr 业务附件
     * @return 业务附件集合
     */
    public List<TBusisysattr> selectTBusisysattrList(TBusisysattr tBusisysattr);

    /**
     * 新增业务附件
     * 
     * @param tBusisysattr 业务附件
     * @return 结果
     */
    public int insertTBusisysattr(TBusisysattr tBusisysattr);

    /**
     * 修改业务附件
     * 
     * @param tBusisysattr 业务附件
     * @return 结果
     */
    public int updateTBusisysattr(TBusisysattr tBusisysattr);

    /**
     * 删除业务附件
     * 
     * @param unid 业务附件主键
     * @return 结果
     */
    public int deleteTBusisysattrByUnid(String unid);

    /**
     * 批量删除业务附件
     * 
     * @param unids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTBusisysattrByUnids(String[] unids);
}
