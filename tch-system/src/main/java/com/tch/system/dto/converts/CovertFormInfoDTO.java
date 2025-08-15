package com.tch.system.dto.converts;


import com.tch.system.entity.common.CovertItem;
import lombok.Data;

import java.util.List;

@Data
public class CovertFormInfoDTO {

    private String formInfoId;


    private String busISysInfoUuid;


    private String unid;


    private String formName;


    private String formAlias;


    private List<CovertItem> covertItems;

}
