package com.ruoyi.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.test.domain.PwPesticideInventory;
import com.ruoyi.test.mapper.PwPesticideInventoryMapper;
import com.ruoyi.test.service.IPwPesticideInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 农药库存Service业务层处理
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@Service
public class PwPesticideInventoryServiceImpl extends ServiceImpl<PwPesticideInventoryMapper, PwPesticideInventory> implements IPwPesticideInventoryService {
    @Autowired
    private PwPesticideInventoryMapper pwPesticideInventoryMapper;

    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<PwPesticideInventory> queryList(PwPesticideInventory pwPesticideInventory) {
        return pwPesticideInventoryMapper.queryList(pwPesticideInventory);
    }
}
