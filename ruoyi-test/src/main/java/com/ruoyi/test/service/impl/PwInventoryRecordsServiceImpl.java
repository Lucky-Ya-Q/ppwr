package com.ruoyi.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.test.domain.PwInventoryRecords;
import com.ruoyi.test.mapper.PwInventoryRecordsMapper;
import com.ruoyi.test.service.IPwInventoryRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入库记录Service业务层处理
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@Service
public class PwInventoryRecordsServiceImpl extends ServiceImpl<PwInventoryRecordsMapper, PwInventoryRecords> implements IPwInventoryRecordsService {
    @Autowired
    private PwInventoryRecordsMapper pwInventoryRecordsMapper;

    @Override
    public List<PwInventoryRecords> queryList(PwInventoryRecords pwInventoryRecords) {
        return pwInventoryRecordsMapper.queryList(pwInventoryRecords);
    }
}
