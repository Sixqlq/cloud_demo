package com.qlq.cloudalibabaseatastock8802.service.impl;

import com.qlq.cloudalibabaseatastock8802.mapper.StockMapper;
import com.qlq.cloudalibabaseatastock8802.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StockServiceImpl implements StockService{

    @Resource
    private StockMapper stockMapper;
    @Override
    public void decrement() {
        stockMapper.decrement();
    }
}
