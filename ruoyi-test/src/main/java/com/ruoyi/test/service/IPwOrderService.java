package com.ruoyi.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.test.domain.PwOrder;

import java.util.List;

/**
 * 订单Service接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface IPwOrderService extends IService<PwOrder> {
    List<PwOrder> queryList(PwOrder pwOrder);
}
