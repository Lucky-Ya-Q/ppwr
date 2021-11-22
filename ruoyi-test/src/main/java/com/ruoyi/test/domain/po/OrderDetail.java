package com.ruoyi.test.domain.po;

import com.ruoyi.test.domain.PwOrder;
import com.ruoyi.test.domain.PwOrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetail {
    private PwOrder pwOrder;
    private List<PwOrderItem> pwOrderItemList;
}
