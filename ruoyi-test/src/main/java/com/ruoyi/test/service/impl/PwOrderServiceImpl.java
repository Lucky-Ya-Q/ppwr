package com.ruoyi.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.test.domain.PwOrder;
import com.ruoyi.test.mapper.PwOrderMapper;
import com.ruoyi.test.service.IPwOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单Service业务层处理
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@Service
public class PwOrderServiceImpl extends ServiceImpl<PwOrderMapper, PwOrder> implements IPwOrderService {
    @Autowired
    private PwOrderMapper pwOrderMapper;

    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<PwOrder> queryList(PwOrder pwOrder) {
        return pwOrderMapper.queryList(pwOrder);
    }
}
