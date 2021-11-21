package com.ruoyi.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.test.domain.PwInventoryRecords;
import com.ruoyi.test.domain.PwPesticideBasicInfo;
import com.ruoyi.test.domain.PwPesticideInventory;
import com.ruoyi.test.domain.vo.PutStorage;
import com.ruoyi.test.mapper.PwInventoryRecordsMapper;
import com.ruoyi.test.mapper.PwPesticideBasicInfoMapper;
import com.ruoyi.test.mapper.PwPesticideInventoryMapper;
import com.ruoyi.test.mapper.StatisticalMapper;
import com.ruoyi.test.service.IStatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatisticalServiceImpl implements IStatisticalService {
    @Autowired
    private StatisticalMapper statisticalMapper;
    @Autowired
    private PwPesticideBasicInfoMapper pwPesticideBasicInfoMapper;
    @Autowired
    private PwPesticideInventoryMapper pwPesticideInventoryMapper;
    @Autowired
    private PwInventoryRecordsMapper pwInventoryRecordsMapper;

    @Override
    @Transactional
    public void putStorage(PutStorage putStorage) {
        Long basicInfoId = putStorage.getBasicInfoId();

        PwPesticideBasicInfo pwPesticideBasicInfo = pwPesticideBasicInfoMapper.selectById(basicInfoId);
        if (pwPesticideBasicInfo == null) {
            throw new ServiceException("basicInfoId不存在");
        }

        QueryWrapper<PwPesticideInventory> pwPesticideInventoryQueryWrapper = new QueryWrapper<>();
        pwPesticideInventoryQueryWrapper.eq("basic_info_id", basicInfoId);
        PwPesticideInventory pwPesticideInventory = pwPesticideInventoryMapper.selectOne(pwPesticideInventoryQueryWrapper);
        if (pwPesticideInventory == null) {
            // 添加库存
            pwPesticideInventory = new PwPesticideInventory();
            pwPesticideInventory.setBasicInfoId(pwPesticideBasicInfo.getId());
            pwPesticideInventory.setName(pwPesticideBasicInfo.getName());
            pwPesticideInventory.setImgs(pwPesticideBasicInfo.getImgs());
            pwPesticideInventory.setManufacturer(pwPesticideBasicInfo.getManufacturer());
            pwPesticideInventory.setPrice(putStorage.getPrice());
            pwPesticideInventory.setDeposit(putStorage.getDeposit());
            pwPesticideInventory.setNumber(putStorage.getNumber());
            pwPesticideInventoryMapper.insert(pwPesticideInventory);
        } else {
            // 修改库存
            statisticalMapper.putStorage(putStorage);
        }

        // 入库记录
        PwInventoryRecords pwInventoryRecords = new PwInventoryRecords();
        pwInventoryRecords.setBasicInfoId(pwPesticideBasicInfo.getId());
        pwInventoryRecords.setName(pwPesticideBasicInfo.getName());
        pwInventoryRecords.setImgs(pwPesticideBasicInfo.getImgs());
        pwInventoryRecords.setManufacturer(pwPesticideBasicInfo.getManufacturer());
        pwInventoryRecords.setPrice(putStorage.getPrice());
        pwInventoryRecords.setDeposit(putStorage.getDeposit());
        pwInventoryRecords.setNumber(putStorage.getNumber());
        pwInventoryRecordsMapper.insert(pwInventoryRecords);
    }
}
