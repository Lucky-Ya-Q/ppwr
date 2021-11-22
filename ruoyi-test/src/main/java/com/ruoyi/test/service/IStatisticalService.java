package com.ruoyi.test.service;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.test.domain.po.OrderDetail;
import com.ruoyi.test.domain.vo.Order;
import com.ruoyi.test.domain.vo.PutStorage;

import java.util.List;
import java.util.Map;

public interface IStatisticalService {
    void putStorage(PutStorage putStorage);

    void buy(Order order);

    void huishou(Long itemId);

    void tuihuo(Long itemId);

    OrderDetail getOrderInfoByOrderNumber(String orderNumber);

    Map<String, String> count(BaseEntity baseEntity);

    void qingyun();

    List<Map<String, Object>> quxianxshs();
}
