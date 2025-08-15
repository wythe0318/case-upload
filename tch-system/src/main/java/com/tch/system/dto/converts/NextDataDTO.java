package com.tch.system.dto.converts;

import com.tch.system.entity.common.ConvertBaseData;
import com.tch.system.entity.common.CovertDocument;
import com.tch.system.entity.common.Router;
import com.tch.system.entity.next2xml.Attr;
import com.tch.system.vo.converts.NextDataVO;
import lombok.Data;

import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/22 17:20
 */
@Data
public class NextDataDTO {
	private Router router;
	private ConvertBaseData convertBaseData;
	private NextDataVO nextData;
	private List<Attr> attrs;
	private List<CovertDocument> documents;
}
