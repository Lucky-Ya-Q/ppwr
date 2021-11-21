package com.ruoyi.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.test.domain.PwPesticideInventory;

import java.util.List;

/**
 * 农药库存Mapper接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface PwPesticideInventoryMapper extends BaseMapper<PwPesticideInventory> {
    List<PwPesticideInventory> queryList(PwPesticideInventory pwPesticideInventory);
}
