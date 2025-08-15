package com.tch.system.mapper;

import com.tch.system.domain.TResourceInfo;

import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/11 15:00
 */

public interface TResourceInfoMapper {


    List<TResourceInfo> selectTResourceInfoDataList(String unId);

    TResourceInfo selectTResourceInfoDataResultSuccess(String uuid);

    TResourceInfo selectTResourceInfoDataResultRepeat(String uuid);

}
