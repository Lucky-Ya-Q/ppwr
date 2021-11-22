package com.ruoyi.test.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单项对象 pw_order_item
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PwOrderItem extends BaseEntity {
    /**
     * ID
     */
    private Long id;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 库存ID
     */
    private Long inventoryId;

    /**
     * 农药名称
     */
    @Excel(name = "农药名称")
    private String name;

    /**
     * 产品包装
     */
    @Excel(name = "产品包装")
    private String imgs;

    /**
     * 生产厂家
     */
    @Excel(name = "生产厂家")
    private String manufacturer;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private BigDecimal price;

    /**
     * 押金
     */
    @Excel(name = "押金")
    private BigDecimal deposit;

    /**
     * 数量
     */
    @Excel(name = "数量")
    private Long number;

    /**
     * 是否回收
     */
    @Excel(name = "是否回收")
    private Long isRecycle;

    /**
     * 回收时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回收时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recycleTime;

    /**
     * 是否退货
     */
    @Excel(name = "是否退货")
    private Long isReturn;

    /**
     * 退货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date returnTime;

    /**
     * 是否清运
     */
    @Excel(name = "是否清运")
    private Long isClear;

    /**
     * 清运时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "清运时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date clearTime;

    /**
     * 用户ID
     */
    @TableField(fill = FieldFill.INSERT)
    private Long userId;

    /**
     * 部门ID
     */
    @TableField(fill = FieldFill.INSERT)
    private Long deptId;
}
