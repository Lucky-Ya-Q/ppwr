package com.ruoyi.test.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.PwInventoryRecords;
import com.ruoyi.test.service.IPwInventoryRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 入库记录Controller
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@RestController
@RequestMapping("/test/records")
public class PwInventoryRecordsController extends BaseController {
    @Autowired
    private IPwInventoryRecordsService pwInventoryRecordsService;

    /**
     * 查询入库记录列表
     */
    @PreAuthorize("@ss.hasPermi('test:records:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwInventoryRecords pwInventoryRecords) {
        startPage();
        List<PwInventoryRecords> list = pwInventoryRecordsService.queryList(pwInventoryRecords);
        return getDataTable(list);
    }

    /**
     * 导出入库记录列表
     */
    @PreAuthorize("@ss.hasPermi('test:records:export')")
    @Log(title = "入库记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PwInventoryRecords pwInventoryRecords) {
        List<PwInventoryRecords> list = pwInventoryRecordsService.queryList(pwInventoryRecords);
        ExcelUtil<PwInventoryRecords> util = new ExcelUtil<PwInventoryRecords>(PwInventoryRecords.class);
        util.exportExcel(response, list, "入库记录数据");
    }

    /**
     * 获取入库记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:records:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pwInventoryRecordsService.getById(id));
    }

    /**
     * 新增入库记录
     */
    @PreAuthorize("@ss.hasPermi('test:records:add')")
    @Log(title = "入库记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PwInventoryRecords pwInventoryRecords) {
        return toAjax(pwInventoryRecordsService.save(pwInventoryRecords));
    }

    /**
     * 修改入库记录
     */
    @PreAuthorize("@ss.hasPermi('test:records:edit')")
    @Log(title = "入库记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwInventoryRecords pwInventoryRecords) {
        return toAjax(pwInventoryRecordsService.updateById(pwInventoryRecords));
    }

    /**
     * 删除入库记录
     */
    @PreAuthorize("@ss.hasPermi('test:records:remove')")
    @Log(title = "入库记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pwInventoryRecordsService.removeByIds(Arrays.asList(ids)));
    }
}
