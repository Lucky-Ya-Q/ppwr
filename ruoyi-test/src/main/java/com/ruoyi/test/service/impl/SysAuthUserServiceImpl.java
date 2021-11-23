package com.ruoyi.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.test.domain.SysAuthUser;
import com.ruoyi.test.mapper.SysAuthUserMapper;
import com.ruoyi.test.service.ISysAuthUserService;
import org.springframework.stereotype.Service;

/**
 * 第三方授权Service业务层处理
 *
 * @author lucky-ya-q
 * @date 2021-11-23
 */
@Service
public class SysAuthUserServiceImpl extends ServiceImpl<SysAuthUserMapper, SysAuthUser> implements ISysAuthUserService {
}
