package com.ruoyi.test.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.PwPesticideInventory;
import com.ruoyi.test.service.IPwPesticideInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 农药库存Controller
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@RestController
@RequestMapping("/test/inventory")
public class PwPesticideInventoryController extends BaseController {
    @Autowired
    private IPwPesticideInventoryService pwPesticideInventoryService;

    /**
     * 查询农药库存列表
     */
    @PreAuthorize("@ss.hasPermi('test:inventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwPesticideInventory pwPesticideInventory) {
        startPage();
        List<PwPesticideInventory> list = pwPesticideInventoryService.queryList(pwPesticideInventory);
        return getDataTable(list);
    }

    /**
     * 导出农药库存列表
     */
    @PreAuthorize("@ss.hasPermi('test:inventory:export')")
    @Log(title = "农药库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PwPesticideInventory pwPesticideInventory) {
        List<PwPesticideInventory> list = pwPesticideInventoryService.queryList(pwPesticideInventory);
        ExcelUtil<PwPesticideInventory> util = new ExcelUtil<PwPesticideInventory>(PwPesticideInventory.class);
        util.exportExcel(response, list, "农药库存数据");
    }

    /**
     * 获取农药库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:inventory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pwPesticideInventoryService.getById(id));
    }

    /**
     * 新增农药库存
     */
    @PreAuthorize("@ss.hasPermi('test:inventory:add')")
    @Log(title = "农药库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PwPesticideInventory pwPesticideInventory) {
        return toAjax(pwPesticideInventoryService.save(pwPesticideInventory));
    }

    /**
     * 修改农药库存
     */
    @PreAuthorize("@ss.hasPermi('test:inventory:edit')")
    @Log(title = "农药库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwPesticideInventory pwPesticideInventory) {
        return toAjax(pwPesticideInventoryService.updateById(pwPesticideInventory));
    }

    /**
     * 删除农药库存
     */
    @PreAuthorize("@ss.hasPermi('test:inventory:remove')")
    @Log(title = "农药库存", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pwPesticideInventoryService.removeByIds(Arrays.asList(ids)));
    }
}
