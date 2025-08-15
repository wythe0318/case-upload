package com.tch.system.dto.converts;

import lombok.Data;

import java.util.List;

/**
 * @author duanjunlong
 * @data 2024/4/19 17:29
 */

@Data
public class ConvertDTO {

	private WsspDataDTO wsspDataDTO;

	private List<NextDataDTO> nextDataDTOS;

	private FinishDataDTO finishDataDTO;


}
