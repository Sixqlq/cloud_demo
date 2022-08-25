package com.qlq.cloudalibabaseataorder8801.controller;

import com.qlq.cloudalibabaseataorder8801.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    @GlobalTransactional// 开启分布式事务
    public String create(){
        orderService.create();
        return "生成订单";
    }

}
