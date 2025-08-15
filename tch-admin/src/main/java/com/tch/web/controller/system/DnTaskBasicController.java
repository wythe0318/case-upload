package com.tch.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tch.common.annotation.Log;
import com.tch.common.enums.BusinessType;
import com.tch.system.domain.DnTaskBasic;
import com.tch.system.service.IDnTaskBasicService;
import com.tch.common.core.controller.BaseController;
import com.tch.common.core.domain.AjaxResult;
import com.tch.common.utils.poi.ExcelUtil;
import com.tch.common.core.page.TableDataInfo;

/**
 * 事项基本信息Controller
 * 
 * @author wythe
 * @date 2024-03-26
 */
@Controller
@RequestMapping("/system/basic")
public class DnTaskBasicController extends BaseController
{
    private String prefix = "system/basic";

    @Autowired
    private IDnTaskBasicService dnTaskBasicService;

    @RequiresPermissions("system:basic:view")
    @GetMapping()
    public String basic()
    {
        return prefix + "/basic";
    }

    /**
     * 查询事项基本信息列表
     */
    @RequiresPermissions("system:basic:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DnTaskBasic dnTaskBasic)
    {
        startPage();
        List<DnTaskBasic> list = dnTaskBasicService.selectDnTaskBasicList(dnTaskBasic);
        return getDataTable(list);
    }

    /**
     * 导出事项基本信息列表
     */
    @RequiresPermissions("system:basic:export")
    @Log(title = "事项基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DnTaskBasic dnTaskBasic)
    {
        List<DnTaskBasic> list = dnTaskBasicService.selectDnTaskBasicList(dnTaskBasic);
        ExcelUtil<DnTaskBasic> util = new ExcelUtil<DnTaskBasic>(DnTaskBasic.class);
        return util.exportExcel(list, "事项基本信息数据");
    }

    /**
     * 新增事项基本信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存事项基本信息
     */
    @RequiresPermissions("system:basic:add")
    @Log(title = "事项基本信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DnTaskBasic dnTaskBasic)
    {
        return toAjax(dnTaskBasicService.insertDnTaskBasic(dnTaskBasic));
    }

    /**
     * 修改事项基本信息
     */
    @RequiresPermissions("system:basic:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DnTaskBasic dnTaskBasic = dnTaskBasicService.selectDnTaskBasicById(id);
        mmap.put("dnTaskBasic", dnTaskBasic);
        return prefix + "/edit";
    }

    /**
     * 修改保存事项基本信息
     */
    @RequiresPermissions("system:basic:edit")
    @Log(title = "事项基本信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DnTaskBasic dnTaskBasic)
    {
        return toAjax(dnTaskBasicService.updateDnTaskBasic(dnTaskBasic));
    }

    /**
     * 删除事项基本信息
     */
    @RequiresPermissions("system:basic:remove")
    @Log(title = "事项基本信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dnTaskBasicService.deleteDnTaskBasicByIds(ids));
    }
}
