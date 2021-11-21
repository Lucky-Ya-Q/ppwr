package com.ruoyi.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.test.domain.PwOrderItem;

import java.util.List;

/**
 * 订单项Mapper接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface PwOrderItemMapper extends BaseMapper<PwOrderItem> {
    List<PwOrderItem> queryList(PwOrderItem pwOrderItem);
}
