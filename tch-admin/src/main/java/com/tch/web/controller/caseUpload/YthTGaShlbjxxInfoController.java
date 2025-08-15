package com.tch.web.controller.caseUpload;

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
import com.tch.system.domain.YthTGaShlbjxxInfo;
import com.tch.system.service.IYthTGaShlbjxxInfoService;
import com.tch.common.core.controller.BaseController;
import com.tch.common.core.domain.AjaxResult;
import com.tch.common.utils.poi.ExcelUtil;
import com.tch.common.core.page.TableDataInfo;

/**
 * caseUploadController
 * 
 * @author Wythe
 * @date 2024-03-17
 */
@Controller
@RequestMapping("/system/caseUpload")
public class YthTGaShlbjxxInfoController extends BaseController
{
    private String prefix = "system/caseUpload";

    @Autowired
    private IYthTGaShlbjxxInfoService ythTGaShlbjxxInfoService;

    @RequiresPermissions("system:caseUpload:view")
    @GetMapping()
    public String caseUpload()
    {
        return prefix + "/caseUpload";
    }

    /**
     * 查询caseUpload列表
     */
    @RequiresPermissions("system:caseUpload:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YthTGaShlbjxxInfo ythTGaShlbjxxInfo)
    {
        startPage();
        List<YthTGaShlbjxxInfo> list = ythTGaShlbjxxInfoService.selectYthTGaShlbjxxInfoList(ythTGaShlbjxxInfo);
        return getDataTable(list);
    }

    /**
     * 导出caseUpload列表
     */
    @RequiresPermissions("system:caseUpload:export")
    @Log(title = "caseUpload", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YthTGaShlbjxxInfo ythTGaShlbjxxInfo)
    {
        List<YthTGaShlbjxxInfo> list = ythTGaShlbjxxInfoService.selectYthTGaShlbjxxInfoList(ythTGaShlbjxxInfo);
        ExcelUtil<YthTGaShlbjxxInfo> util = new ExcelUtil<YthTGaShlbjxxInfo>(YthTGaShlbjxxInfo.class);
        return util.exportExcel(list, "caseUpload数据");
    }

    /**
     * 新增caseUpload
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存caseUpload
     */
    @RequiresPermissions("system:caseUpload:add")
    @Log(title = "caseUpload", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YthTGaShlbjxxInfo ythTGaShlbjxxInfo)
    {
        return toAjax(ythTGaShlbjxxInfoService.insertYthTGaShlbjxxInfo(ythTGaShlbjxxInfo));
    }

    /**
     * 修改caseUpload
     */
    @RequiresPermissions("system:caseUpload:edit")
    @GetMapping("/edit/{provincePullDataAuditId}")
    public String edit(@PathVariable("provincePullDataAuditId") String provincePullDataAuditId, ModelMap mmap)
    {
        YthTGaShlbjxxInfo ythTGaShlbjxxInfo = ythTGaShlbjxxInfoService.selectYthTGaShlbjxxInfoByProvincePullDataAuditId(provincePullDataAuditId);
        mmap.put("ythTGaShlbjxxInfo", ythTGaShlbjxxInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存caseUpload
     */
    @RequiresPermissions("system:caseUpload:edit")
    @Log(title = "caseUpload", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YthTGaShlbjxxInfo ythTGaShlbjxxInfo)
    {
        return toAjax(ythTGaShlbjxxInfoService.updateYthTGaShlbjxxInfo(ythTGaShlbjxxInfo));
    }

    /**
     * 删除caseUpload
     */
    @RequiresPermissions("system:caseUpload:remove")
    @Log(title = "caseUpload", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ythTGaShlbjxxInfoService.deleteYthTGaShlbjxxInfoByProvincePullDataAuditIds(ids));
    }
}
