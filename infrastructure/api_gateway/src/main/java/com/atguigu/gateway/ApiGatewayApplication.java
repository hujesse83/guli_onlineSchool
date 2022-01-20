package com.atguigu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jesse.hu
 * @date 2022/1/20 16:38
 */
@SpringBootApplication
@EnableDiscoveryClient    // 不加注解nacos也能添加至注册中心
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}