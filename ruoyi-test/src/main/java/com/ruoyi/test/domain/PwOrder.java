package com.ruoyi.test.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单对象 pw_order
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PwOrder extends BaseEntity {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    @Excel(name = "订单号")
    private String orderNumber;

    /**
     * 购买人姓名
     */
    @Excel(name = "购买人姓名")
    private String buyerName;

    /**
     * 购买人手机号
     */
    @Excel(name = "购买人手机号")
    private String buyerPhone;

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
