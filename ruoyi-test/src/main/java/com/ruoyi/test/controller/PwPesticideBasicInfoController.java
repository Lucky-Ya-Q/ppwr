package com.ruoyi.test.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.PwPesticideBasicInfo;
import com.ruoyi.test.service.IPwPesticideBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 农药基本信息Controller
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@RestController
@RequestMapping("/test/info")
public class PwPesticideBasicInfoController extends BaseController {
    @Autowired
    private IPwPesticideBasicInfoService pwPesticideBasicInfoService;

    /**
     * 查询农药基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('test:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwPesticideBasicInfo pwPesticideBasicInfo) {
        startPage();
        List<PwPesticideBasicInfo> list = pwPesticideBasicInfoService.queryList(pwPesticideBasicInfo);
        return getDataTable(list);
    }

    /**
     * 导出农药基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('test:info:export')")
    @Log(title = "农药基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PwPesticideBasicInfo pwPesticideBasicInfo) {
        List<PwPesticideBasicInfo> list = pwPesticideBasicInfoService.queryList(pwPesticideBasicInfo);
        ExcelUtil<PwPesticideBasicInfo> util = new ExcelUtil<PwPesticideBasicInfo>(PwPesticideBasicInfo.class);
        util.exportExcel(response, list, "农药基本信息数据");
    }

    /**
     * 获取农药基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pwPesticideBasicInfoService.getById(id));
    }

    /**
     * 新增农药基本信息
     */
    @PreAuthorize("@ss.hasPermi('test:info:add')")
    @Log(title = "农药基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PwPesticideBasicInfo pwPesticideBasicInfo) {
        return toAjax(pwPesticideBasicInfoService.save(pwPesticideBasicInfo));
    }

    /**
     * 修改农药基本信息
     */
    @PreAuthorize("@ss.hasPermi('test:info:edit')")
    @Log(title = "农药基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwPesticideBasicInfo pwPesticideBasicInfo) {
        return toAjax(pwPesticideBasicInfoService.updateById(pwPesticideBasicInfo));
    }

    /**
     * 删除农药基本信息
     */
    @PreAuthorize("@ss.hasPermi('test:info:remove')")
    @Log(title = "农药基本信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pwPesticideBasicInfoService.removeByIds(Arrays.asList(ids)));
    }
}
