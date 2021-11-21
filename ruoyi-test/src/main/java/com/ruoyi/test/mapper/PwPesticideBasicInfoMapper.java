package com.ruoyi.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.test.domain.PwPesticideBasicInfo;

import java.util.List;

/**
 * 农药基本信息Mapper接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface PwPesticideBasicInfoMapper extends BaseMapper<PwPesticideBasicInfo> {
    List<PwPesticideBasicInfo> queryList(PwPesticideBasicInfo pwPesticideBasicInfo);
}
