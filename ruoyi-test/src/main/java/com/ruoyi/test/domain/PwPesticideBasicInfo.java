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
 * 农药基本信息对象 pw_pesticide_basic_info
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PwPesticideBasicInfo extends BaseEntity {
    /**
     * ID
     */
    private Long id;

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
