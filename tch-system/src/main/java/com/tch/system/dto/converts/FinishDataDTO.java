package com.tch.system.dto.converts;

import com.tch.system.entity.common.ConvertBaseData;
import com.tch.system.entity.common.CovertDocument;
import com.tch.system.entity.common.Router;
import com.tch.system.entity.finish2xml.FinishAttr;
import com.tch.system.entity.xml2bean.FinishLicense;
import com.tch.system.entity.xml2bean.FinishResultAttr;
import com.tch.system.vo.converts.FinishDataVO;
import lombok.Data;

import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/23 14:50
 */
@Data
public class FinishDataDTO {
	private Router router;
	private ConvertBaseData convertBaseData;
	private FinishDataVO finishData;
	private List<CovertDocument> documents;
	private List<FinishAttr> finishAttrs;
	private List<FinishLicense> finishLicenses;
	private List<FinishResultAttr> finishResultAttrs;
	private List<CovertFormInfoDTO> finishFormInfo;
}
