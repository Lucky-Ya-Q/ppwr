package com.ruoyi.test.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.test.domain.vo.Order;
import com.ruoyi.test.domain.vo.PutStorage;
import com.ruoyi.test.service.IStatisticalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        // statisticalService.buy(order);
        return AjaxResult.success();
    }
}
