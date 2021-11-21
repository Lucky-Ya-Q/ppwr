package com.ruoyi.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.test.domain.PwPesticideInventory;

import java.util.List;

/**
 * 农药库存Service接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface IPwPesticideInventoryService extends IService<PwPesticideInventory> {
    List<PwPesticideInventory> queryList(PwPesticideInventory pwPesticideInventory);
}
