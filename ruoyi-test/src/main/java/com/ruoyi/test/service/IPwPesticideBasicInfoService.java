package com.ruoyi.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.test.domain.PwPesticideBasicInfo;

import java.util.List;

/**
 * 农药基本信息Service接口
 *
 * @author ruoyi
 * @date 2021-11-21
 */
public interface IPwPesticideBasicInfoService extends IService<PwPesticideBasicInfo> {
    List<PwPesticideBasicInfo> queryList(PwPesticideBasicInfo pwPesticideBasicInfo);
}
