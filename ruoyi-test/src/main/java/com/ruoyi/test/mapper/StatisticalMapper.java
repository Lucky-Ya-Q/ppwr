package com.ruoyi.test.mapper;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.test.domain.vo.PutStorage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisticalMapper {
    void putStorage(@Param("putStorage") PutStorage putStorage, @Param("deptId") Long deptId);

    int reduceStorage(@Param("inventoryId") Long inventoryId, @Param("number") int number, @Param("deptId") Long deptId);

    void huishou(@Param("itemId") Long itemId, @Param("deptId") Long deptId);

    void tuihuo(@Param("itemId") Long itemId, @Param("deptId") Long deptId);

    Map<String, String> count(BaseEntity baseEntity);

    void qingyun(Long deptId);

    List<SysDept> getNextOneByDeptId(int deptId);

    Map<String, Object> quxianxshs(Long deptId);

    List<Map<String, Object>> yuefenxshs();

    List<Map<String, Object>> quxianhscz();
}
