package com.qlq.cloudalibabaseatastock8802;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.qlq.cloudalibabaseatastock8802.mapper")
@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaSeataStock8802Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSeataStock8802Application.class, args);
    }

}
