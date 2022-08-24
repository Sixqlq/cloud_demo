package com.qlq.cloudalibabasentinelservice8401.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 处理自定义限流逻辑
 */
public class CustomerBlockHandler {
    // 方法必须是static
    public static String handlerException1(BlockException blockException){
        return "handlerException1：系统异常，请稍后重试！";
    }

    public static String handlerException2(BlockException exception){
        return "handlerException2：网络崩溃了，请稍后重试！";
    }
}
