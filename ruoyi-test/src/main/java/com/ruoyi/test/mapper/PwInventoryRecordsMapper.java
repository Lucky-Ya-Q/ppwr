package com.ruoyi.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.test.domain.PwInventoryRecords;

import java.util.List;

/**
 * 入库记录Mapper接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface PwInventoryRecordsMapper extends BaseMapper<PwInventoryRecords> {
    List<PwInventoryRecords> queryList(PwInventoryRecords pwInventoryRecords);
}
