package com.ruoyi.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.test.domain.PwOrderItem;
import com.ruoyi.test.mapper.PwOrderItemMapper;
import com.ruoyi.test.service.IPwOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单项Service业务层处理
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@Service
public class PwOrderItemServiceImpl extends ServiceImpl<PwOrderItemMapper, PwOrderItem> implements IPwOrderItemService {
    @Autowired
    private PwOrderItemMapper pwOrderItemMapper;

    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<PwOrderItem> queryList(PwOrderItem pwOrderItem) {
        return pwOrderItemMapper.queryList(pwOrderItem);
    }
}
