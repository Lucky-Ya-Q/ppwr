package com.ruoyi.test.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PutStorage {
    /**
     * 基本信息ID
     */
    @ApiModelProperty("基本信息ID")
    private Long basicInfoId;
    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private BigDecimal price;

    /**
     * 押金
     */
    @ApiModelProperty("押金")
    private BigDecimal deposit;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Long number;
}
