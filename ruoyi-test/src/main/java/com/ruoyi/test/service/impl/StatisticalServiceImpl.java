package com.ruoyi.test.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.test.domain.*;
import com.ruoyi.test.domain.po.OrderDetail;
import com.ruoyi.test.domain.vo.Order;
import com.ruoyi.test.domain.vo.PutStorage;
import com.ruoyi.test.mapper.*;
import com.ruoyi.test.service.IStatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private PwOrderMapper pwOrderMapper;
    @Autowired
    private PwOrderItemMapper pwOrderItemMapper;

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
        pwPesticideInventoryQueryWrapper.eq("dept_id", SecurityUtils.getDeptId());
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
            statisticalMapper.putStorage(putStorage, SecurityUtils.getDeptId());
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

    @Override
    @Transactional
    public void buy(Order order) {
        List<Long> inventoryIdList = order.getInventoryIdList();
        for (Long inventoryId : inventoryIdList) {
            int count = statisticalMapper.reduceStorage(inventoryId, 1, SecurityUtils.getDeptId());
            if (count == 0) {
                throw new ServiceException("库存不足");
            }
        }
        PwOrder pwOrder = new PwOrder();

        int orderNumber = RandomUtil.randomInt(100000, 1000000);
        Integer count = pwOrderMapper.selectCount(new QueryWrapper<PwOrder>().eq("order_number", orderNumber));

        while (count != 0) {
            orderNumber = RandomUtil.randomInt(100000, 1000000);
            count = pwOrderMapper.selectCount(new QueryWrapper<PwOrder>().eq("order_number", orderNumber));
        }

        pwOrder.setOrderNumber(String.valueOf(orderNumber));
        pwOrder.setBuyerName(order.getBuyerName());
        pwOrder.setBuyerPhone(order.getBuyerPhone());
        pwOrderMapper.insert(pwOrder);

        for (Long inventoryId : inventoryIdList) {
            PwPesticideInventory pwPesticideInventory = pwPesticideInventoryMapper.selectById(inventoryId);
            PwOrderItem pwOrderItem = new PwOrderItem();
            pwOrderItem.setOrderId(pwOrder.getId());
            pwOrderItem.setInventoryId(pwPesticideInventory.getId());
            pwOrderItem.setName(pwPesticideInventory.getName());
            pwOrderItem.setImgs(pwPesticideInventory.getImgs());
            pwOrderItem.setManufacturer(pwPesticideInventory.getManufacturer());
            pwOrderItem.setPrice(pwPesticideInventory.getPrice());
            pwOrderItem.setDeposit(pwPesticideInventory.getDeposit());
            pwOrderItem.setNumber(1L);
            pwOrderItem.setIsRecycle(0L);
            pwOrderItem.setIsReturn(0L);
            pwOrderItemMapper.insert(pwOrderItem);
        }
    }

    @Override
    public void huishou(Long itemId) {
        statisticalMapper.huishou(itemId, SecurityUtils.getDeptId());
    }

    @Override
    public void tuihuo(Long itemId) {
        statisticalMapper.tuihuo(itemId, SecurityUtils.getDeptId());
    }

    @Override
    public OrderDetail getOrderInfoByOrderNumber(String orderNumber) {
        QueryWrapper<PwOrder> pwOrderQueryWrapper = new QueryWrapper<>();
        pwOrderQueryWrapper.eq("order_number", orderNumber);
        PwOrder pwOrder = pwOrderMapper.selectOne(pwOrderQueryWrapper);
        QueryWrapper<PwOrderItem> pwOrderItemQueryWrapper = new QueryWrapper<>();
        pwOrderItemQueryWrapper.eq("order_id", pwOrder.getId());
        List<PwOrderItem> pwOrderItemList = pwOrderItemMapper.selectList(pwOrderItemQueryWrapper);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setPwOrder(pwOrder);
        orderDetail.setPwOrderItemList(pwOrderItemList);
        return orderDetail;
    }

    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public Map<String, String> count(BaseEntity baseEntity) {
        return statisticalMapper.count(baseEntity);
    }

    @Override
    public void qingyun() {
        statisticalMapper.qingyun(SecurityUtils.getDeptId());
    }

    @Override
    public List<Map<String, Object>> quxianxshs() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<SysDept> sysDeptList = statisticalMapper.getNextOneByDeptId(103);
        for (SysDept sysDept : sysDeptList) {
            Map<String, Object> map = statisticalMapper.quxianxshs(sysDept.getDeptId());
            map.put("deptName", sysDept.getDeptName());
            map.put("deptId", sysDept.getDeptId());
            mapList.add(map);
        }
        return mapList;
    }
}
