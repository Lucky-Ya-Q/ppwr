package com.ruoyi.test.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.PwOrderItem;
import com.ruoyi.test.service.IPwOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 订单项Controller
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@RestController
@RequestMapping("/test/item")
public class PwOrderItemController extends BaseController {
    @Autowired
    private IPwOrderItemService pwOrderItemService;

    /**
     * 查询订单项列表
     */
    @PreAuthorize("@ss.hasPermi('test:item:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwOrderItem pwOrderItem) {
        startPage();
        List<PwOrderItem> list = pwOrderItemService.queryList(pwOrderItem);
        return getDataTable(list);
    }

    /**
     * 导出订单项列表
     */
    @PreAuthorize("@ss.hasPermi('test:item:export')")
    @Log(title = "订单项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PwOrderItem pwOrderItem) {
        List<PwOrderItem> list = pwOrderItemService.queryList(pwOrderItem);
        ExcelUtil<PwOrderItem> util = new ExcelUtil<PwOrderItem>(PwOrderItem.class);
        util.exportExcel(response, list, "订单项数据");
    }

    /**
     * 获取订单项详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:item:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pwOrderItemService.getById(id));
    }

    /**
     * 新增订单项
     */
    @PreAuthorize("@ss.hasPermi('test:item:add')")
    @Log(title = "订单项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PwOrderItem pwOrderItem) {
        return toAjax(pwOrderItemService.save(pwOrderItem));
    }

    /**
     * 修改订单项
     */
    @PreAuthorize("@ss.hasPermi('test:item:edit')")
    @Log(title = "订单项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwOrderItem pwOrderItem) {
        return toAjax(pwOrderItemService.updateById(pwOrderItem));
    }

    /**
     * 删除订单项
     */
    @PreAuthorize("@ss.hasPermi('test:item:remove')")
    @Log(title = "订单项", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pwOrderItemService.removeByIds(Arrays.asList(ids)));
    }
}
