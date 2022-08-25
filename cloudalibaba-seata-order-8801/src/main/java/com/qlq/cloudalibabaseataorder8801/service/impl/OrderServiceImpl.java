package com.qlq.cloudalibabaseataorder8801.service.impl;

import com.qlq.cloudalibabaseataorder8801.client.StockClient;
import com.qlq.cloudalibabaseataorder8801.mapper.OrderMapper;
import com.qlq.cloudalibabaseataorder8801.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StockClient stockClient;

    @Override
    public void create() {
        // 减库存
        stockClient.decrement();

        // 添加异常
        int i = 1/0;// 此处添加断点

        // 创建订单
        orderMapper.create();
    }
}
