package com.ruoyi.test.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.test.domain.PwOrder;
import com.ruoyi.test.service.IPwOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 订单Controller
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@RestController
@RequestMapping("/test/order")
public class PwOrderController extends BaseController {
    @Autowired
    private IPwOrderService pwOrderService;

    /**
     * 查询订单列表
     */
    @PreAuthorize("@ss.hasPermi('test:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwOrder pwOrder) {
        startPage();
        List<PwOrder> list = pwOrderService.queryList(pwOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @PreAuthorize("@ss.hasPermi('test:order:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PwOrder pwOrder) {
        List<PwOrder> list = pwOrderService.queryList(pwOrder);
        ExcelUtil<PwOrder> util = new ExcelUtil<PwOrder>(PwOrder.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pwOrderService.getById(id));
    }

    /**
     * 新增订单
     */
    @PreAuthorize("@ss.hasPermi('test:order:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PwOrder pwOrder) {
        return toAjax(pwOrderService.save(pwOrder));
    }

    /**
     * 修改订单
     */
    @PreAuthorize("@ss.hasPermi('test:order:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwOrder pwOrder) {
        return toAjax(pwOrderService.updateById(pwOrder));
    }

    /**
     * 删除订单
     */
    @PreAuthorize("@ss.hasPermi('test:order:remove')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pwOrderService.removeByIds(Arrays.asList(ids)));
    }
}
