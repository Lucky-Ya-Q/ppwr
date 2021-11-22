package com.ruoyi.test.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.test.domain.po.OrderDetail;
import com.ruoyi.test.domain.vo.Order;
import com.ruoyi.test.domain.vo.PutStorage;
import com.ruoyi.test.service.IStatisticalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "业务模块")
@RestController
@RequestMapping("/test/statistical")
public class StatisticalController {
    @Autowired
    private IStatisticalService statisticalService;

    @ApiOperation(value = "入库")
    @PostMapping("put/storage")
    public AjaxResult putStorage(@RequestBody PutStorage putStorage) {
        statisticalService.putStorage(putStorage);
        return AjaxResult.success();
    }

    @ApiOperation(value = "购买")
    @PostMapping("buy")
    public AjaxResult buy(@RequestBody Order order) {
        statisticalService.buy(order);
        return AjaxResult.success();
    }

    @ApiOperation(value = "根据订单号查订单信息")
    @GetMapping("getOrderInfoByOrderNumber")
    public AjaxResult getOrderInfoByOrderNumber(String orderNumber) {
        OrderDetail orderDetail = statisticalService.getOrderInfoByOrderNumber(orderNumber);
        return AjaxResult.success(orderDetail);
    }

    @ApiOperation(value = "回收")
    @GetMapping("huishou")
    public AjaxResult huishou(Long itemId) {
        statisticalService.huishou(itemId);
        return AjaxResult.success();
    }

    @ApiOperation(value = "退货")
    @GetMapping("tuihuo")
    public AjaxResult tuihuo(Long itemId) {
        statisticalService.tuihuo(itemId);
        return AjaxResult.success();
    }

    @ApiOperation(value = "清运")
    @GetMapping("qingyun")
    public AjaxResult qingyun() {
        statisticalService.qingyun();
        return AjaxResult.success();
    }

    @ApiOperation(value = "统计")
    @GetMapping("count")
    public AjaxResult count() {
        Map<String, String> map = statisticalService.count(new BaseEntity());
        return AjaxResult.success(map);
    }
}
