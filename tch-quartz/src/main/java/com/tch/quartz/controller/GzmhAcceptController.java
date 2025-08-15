package com.tch.quartz.controller;

import com.tch.common.core.domain.AjaxResult;
import com.tch.quartz.service.GzmhAcceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author duanjunlong
 * @data 2024/5/20 10:14
 */
@Controller
@RequestMapping("/gzmhaccept")
public class GzmhAcceptController {


    @Autowired
    private GzmhAcceptService gzmhAcceptService;

    @PostMapping("/transmission")
    @ResponseBody
    public AjaxResult transmission(){
     return  gzmhAcceptService.transmissionData();

    }
}
