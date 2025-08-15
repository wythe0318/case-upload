package com.tch.web.controller.caseUpload;

import com.tch.common.annotation.Log;
import com.tch.common.core.controller.BaseController;
import com.tch.common.core.domain.AjaxResult;
import com.tch.common.core.page.TableDataInfo;
import com.tch.common.enums.BusinessType;
import com.tch.common.utils.poi.ExcelUtil;
import com.tch.system.domain.TBusisysinfo;
import com.tch.system.service.ITBusisysinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 业务系统推送到共享平台的业务数据Controller
 * 
 * @author wythe
 * @date 2024-03-18
 */
@Controller
@RequestMapping("/system/busisysinfo")
public class TBusisysinfoController extends BaseController
{
    private String prefix = "system/busisysinfo";

    @Autowired
    private ITBusisysinfoService tBusisysinfoService;

    @RequiresPermissions("system:busisysinfo:view")
    @GetMapping()
    public String busisysinfo()
    {
        return prefix + "/busisysinfo";
    }

    /**
     * 查询业务系统推送到共享平台的业务数据列表
     */
    @RequiresPermissions("system:busisysinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBusisysinfo tBusisysinfo)
    {
        startPage();
        List<TBusisysinfo> list = tBusisysinfoService.selectTBusisysinfoList(tBusisysinfo);
        return getDataTable(list);
    }

    /**
     * 导出业务系统推送到共享平台的业务数据列表
     */
    @RequiresPermissions("system:busisysinfo:export")
    @Log(title = "业务数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBusisysinfo tBusisysinfo)
    {
        List<TBusisysinfo> list = tBusisysinfoService.selectTBusisysinfoList(tBusisysinfo);
        ExcelUtil<TBusisysinfo> util = new ExcelUtil<TBusisysinfo>(TBusisysinfo.class);
        return util.exportExcel(list, "业务数据");
    }

    /**
     * 新增业务系统推送到共享平台的业务数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存业务系统推送到共享平台的业务数据
     */
    @RequiresPermissions("system:busisysinfo:add")
    @Log(title = "业务数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TBusisysinfo tBusisysinfo)
    {
        return toAjax(tBusisysinfoService.insertTBusisysinfo(tBusisysinfo));
    }

    /**
     * 修改业务系统推送到共享平台的业务数据
     */
    @RequiresPermissions("system:busisysinfo:edit")
    @GetMapping("/edit/{unid}")
    public String edit(@PathVariable("unid") String unid, ModelMap mmap)
    {
        TBusisysinfo tBusisysinfo = tBusisysinfoService.selectTBusisysinfoByUnid(unid);
        mmap.put("tBusisysinfo", tBusisysinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存业务系统推送到共享平台的业务数据
     */
    @RequiresPermissions("system:busisysinfo:edit")
    @Log(title = "业务数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TBusisysinfo tBusisysinfo)
    {
        return toAjax(tBusisysinfoService.updateTBusisysinfo(tBusisysinfo));
    }

    /**
     * 删除业务系统推送到共享平台的业务数据
     */
    @RequiresPermissions("system:busisysinfo:remove")
    @Log(title = "业务数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBusisysinfoService.deleteTBusisysinfoByUnids(ids));
    }
}
