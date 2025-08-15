package com.tch.system.mapper;

import com.tch.system.entity.next2xml.*;

import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/3 17:36
 */

public interface NextXmlMapper {

    // 插入 NextConvertApasInfo
    int insertNextApasInfo(NextConvertApasInfo nextApasInfo);

    public NextConvertApasInfo selectNextApasInfoByUuId(String busISysInfoUuid);

    // 插入 NextCaseEntity
    int insertNextCaseEntity(NextCaseEntity nextCaseEntity);


    // 插入 NextNode
    int insertNextNode(NextNode nextNode);

    public NextNode selectNextNodeByUuId(String busISysInfoUuid);


    int insertNextAttr(Attr attr);


    public List<Attr> selectNextAttrByDataId(String dataId);

}
