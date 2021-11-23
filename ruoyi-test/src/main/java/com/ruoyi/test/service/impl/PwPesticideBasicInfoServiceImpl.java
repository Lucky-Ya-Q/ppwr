package com.ruoyi.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.test.domain.PwPesticideBasicInfo;
import com.ruoyi.test.mapper.PwPesticideBasicInfoMapper;
import com.ruoyi.test.service.IPwPesticideBasicInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 农药基本信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-11-21
 */
@Service
public class PwPesticideBasicInfoServiceImpl extends ServiceImpl<PwPesticideBasicInfoMapper, PwPesticideBasicInfo> implements IPwPesticideBasicInfoService {
    @Override
    public List<PwPesticideBasicInfo> queryList(PwPesticideBasicInfo pwPesticideBasicInfo) {
        return baseMapper.queryList(pwPesticideBasicInfo);
    }
}
