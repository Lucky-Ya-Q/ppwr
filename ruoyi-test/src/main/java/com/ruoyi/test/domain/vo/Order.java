package com.ruoyi.test.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    /**
     * 购买人姓名
     */
    @ApiModelProperty("购买人姓名")
    private String buyerName;

    /**
     * 购买人手机号
     */
    @ApiModelProperty("购买人手机号")
    private String buyerPhone;

    /**
     * 订单项ID列表
     */
    @ApiModelProperty("订单项ID列表")
    private List<Long> itemIdList;
}
