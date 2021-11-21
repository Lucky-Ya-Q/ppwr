package com.ruoyi.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.test.domain.PwInventoryRecords;

import java.util.List;

/**
 * 入库记录Service接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface IPwInventoryRecordsService extends IService<PwInventoryRecords> {
    List<PwInventoryRecords> queryList(PwInventoryRecords pwInventoryRecords);
}
