package com.qlq.cloudalibabasentinelservice8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qlq.cloudalibabasentinelservice8401.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelResourceTestController {
    /**
     * 资源限流
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handler_resource")
    public String byResource(){
        return "-----byResource";
    }

    public String handler_resource(BlockException exception){
        return "系统繁忙";
    }

    /**
     * URL限流
     * 不使用blockHandler属性，系统会调用默认限流异常处理方法
     * @return
     */
    @GetMapping("/byRest")
    @SentinelResource(value = "/byRest")
    public String byRest(){
        return "-----byRest";
    }

    /**
     * 此方法用到了自定义限流处理类型CustomerBlockHandler中的handlerException1方法来处理限流逻辑。
     */
    @GetMapping("/bycustomer")
    @SentinelResource(value = "bycustomer",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public String bycustomer(){
        return "-----bycustomer";
    }
}
