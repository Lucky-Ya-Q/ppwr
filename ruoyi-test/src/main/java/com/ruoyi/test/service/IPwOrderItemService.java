package com.ruoyi.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.test.domain.PwOrderItem;

import java.util.List;

/**
 * 订单项Service接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface IPwOrderItemService extends IService<PwOrderItem> {
    List<PwOrderItem> queryList(PwOrderItem pwOrderItem);
}
