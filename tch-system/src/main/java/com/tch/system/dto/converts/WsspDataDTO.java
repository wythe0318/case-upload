package com.tch.system.dto.converts;


import com.tch.system.entity.common.ConvertBaseData;
import com.tch.system.entity.common.Router;
import com.tch.system.entity.convert2xml.Attr;
import com.tch.system.vo.converts.ConvertDataVO;
import lombok.Data;

import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/22 16:01
 */

@Data
public class WsspDataDTO {
	private Router router;
	private ConvertBaseData convertBaseData;
	private ConvertDataVO convertData;
	private List<Attr> converAttrs;
	private List<CovertFormInfoDTO> covertFormInfo;
}
