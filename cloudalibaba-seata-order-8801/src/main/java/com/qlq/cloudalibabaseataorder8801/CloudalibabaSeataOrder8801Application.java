package com.qlq.cloudalibabaseataorder8801;

import com.qlq.cloudalibabaseataorder8801.client.StockClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = StockClient.class)
@MapperScan("com.qlq.cloudalibabaseataorder8801.mapper")
@EnableDiscoveryClient
public class CloudalibabaSeataOrder8801Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSeataOrder8801Application.class, args);
    }

}
