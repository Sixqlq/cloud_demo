package com.qlq.order.service;

import com.qlq.feign.clients.UserClient;
import com.qlq.feign.pojo.User;
import com.qlq.order.mapper.OrderMapper;
import com.qlq.order.pojo.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Resource
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

//        // 2.利用RestTemplate发起http请求，查询用户
//        String url = "http://userservice/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);

        // 2. 用Feign远程调用
        User user = userClient.findById(order.getUserId());
        // 3.封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
