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
import com.tch.system.domain.TBusisysattr;
import com.tch.system.service.ITBusisysattrService;
import com.tch.common.core.controller.BaseController;
import com.tch.common.core.domain.AjaxResult;
import com.tch.common.utils.poi.ExcelUtil;
import com.tch.common.core.page.TableDataInfo;

/**
 * 业务附件Controller
 * 
 * @author wythe
 * @date 2024-03-18
 */
@Controller
@RequestMapping("/system/busisysattr")
public class TBusisysattrController extends BaseController
{
    private String prefix = "system/busisysattr";

    @Autowired
    private ITBusisysattrService tBusisysattrService;

    @RequiresPermissions("system:busisysattr:view")
    @GetMapping()
    public String busisysattr()
    {
        return prefix + "/busisysattr";
    }

    /**
     * 查询业务附件列表
     */
    @RequiresPermissions("system:busisysattr:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TBusisysattr tBusisysattr)
    {
        startPage();
        List<TBusisysattr> list = tBusisysattrService.selectTBusisysattrList(tBusisysattr);
        return getDataTable(list);
    }

    /**
     * 导出业务附件列表
     */
    @RequiresPermissions("system:busisysattr:export")
    @Log(title = "业务附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TBusisysattr tBusisysattr)
    {
        List<TBusisysattr> list = tBusisysattrService.selectTBusisysattrList(tBusisysattr);
        ExcelUtil<TBusisysattr> util = new ExcelUtil<TBusisysattr>(TBusisysattr.class);
        return util.exportExcel(list, "业务附件数据");
    }

    /**
     * 新增业务附件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存业务附件
     */
    @RequiresPermissions("system:busisysattr:add")
    @Log(title = "业务附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TBusisysattr tBusisysattr)
    {
        return toAjax(tBusisysattrService.insertTBusisysattr(tBusisysattr));
    }

    /**
     * 修改业务附件
     */
    @RequiresPermissions("system:busisysattr:edit")
    @GetMapping("/edit/{unid}")
    public String edit(@PathVariable("unid") String unid, ModelMap mmap)
    {
        TBusisysattr tBusisysattr = tBusisysattrService.selectTBusisysattrByUnid(unid);
        mmap.put("tBusisysattr", tBusisysattr);
        return prefix + "/edit";
    }

    /**
     * 修改保存业务附件
     */
    @RequiresPermissions("system:busisysattr:edit")
    @Log(title = "业务附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TBusisysattr tBusisysattr)
    {
        return toAjax(tBusisysattrService.updateTBusisysattr(tBusisysattr));
    }

    /**
     * 删除业务附件
     */
    @RequiresPermissions("system:busisysattr:remove")
    @Log(title = "业务附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tBusisysattrService.deleteTBusisysattrByUnids(ids));
    }
}
