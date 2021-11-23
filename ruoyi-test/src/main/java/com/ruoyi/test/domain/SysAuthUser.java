package com.ruoyi.test.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 第三方授权对象 sys_auth_user
 *
 * @author lucky-ya-q
 * @date 2021-11-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysAuthUser extends BaseEntity {
    /**
     * 授权ID
     */
    @TableId
    private Long authId;

    /**
     * 第三方平台用户唯一ID
     */
    @Excel(name = "第三方平台用户唯一ID")
    private String uuid;

    /**
     * 系统用户ID
     */
    @Excel(name = "系统用户ID")
    private Long userId;

    /**
     * 登录账号
     */
    @Excel(name = "登录账号")
    private String loginName;

    /**
     * 用户昵称
     */
    @Excel(name = "用户昵称")
    private String userName;

    /**
     * 头像地址
     */
    @Excel(name = "头像地址")
    private String avatar;

    /**
     * 用户邮箱
     */
    @Excel(name = "用户邮箱")
    private String email;

    /**
     * 用户来源
     */
    @Excel(name = "用户来源")
    private String source;
}