package com.qlq.order.web;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qlq.cloudalibabacommons.entity.JsonResult;
import com.qlq.order.pojo.Order;
import com.qlq.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @GetMapping("{orderId}")
    //添加SentinelResource注解的fallback属性，同时设置方法来解决Java异常
    @SentinelResource(value = "falllback",fallback = "fallbackHandler",blockHandler = "blockHandler",
            exceptionsToIgnore = {NullPointerException.class})//被标注的异常将会被原样抛出)
    public JsonResult<Order> queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        if(orderId <= 106){
            // 根据id查询订单并返回
            return new JsonResult<>(200, orderService.queryOrderById(orderId), "OK");
        }else{
            throw new NullPointerException("没有数据");
        }
    }

    /**
     * 处理Java异常
     * @param id
     * @param e
     * @return
     */
    //保证方法签名基本保持一致，但是要添加异常类型参数
    public JsonResult<Order> fallbackHandler(Long id,Throwable e){
        JsonResult<Order>result = new JsonResult<>(444, null, "NullPointerException异常");
        return result;
    }

    /**
     * 处理Sentinel限流
     * @param id
     * @param e
     * @return
     */
    public JsonResult<Order> blockHandler(Long id, BlockException e){
        JsonResult<Order> result = new JsonResult<>(445, null, "BlockException限流");
        return result;
    }


    @GetMapping("/test1")
    @SentinelResource(value = "test1")
    public String test1() throws InterruptedException {
        return "test1 ";
    }

}
