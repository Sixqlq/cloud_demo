package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 配置feign日志级别
 * 在EnableFeignClients注解中声明代表全局配置
 * 在FeignClient注解中声明代表某个具体的服务
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level loglevel() {
        return Logger.Level.BASIC;
    }
}
