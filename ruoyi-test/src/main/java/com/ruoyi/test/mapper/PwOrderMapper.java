package com.ruoyi.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.test.domain.PwOrder;

import java.util.List;

/**
 * 订单Mapper接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface PwOrderMapper extends BaseMapper<PwOrder> {
    List<PwOrder> queryList(PwOrder pwOrder);
}
