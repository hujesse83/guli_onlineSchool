package com.atguigu.educms;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jesse.hu
 * @date 2022/1/13 14:08
 */
@SpringBootApplication
@ComponentScan({"com.atguigu"}) //指定扫描位置 knife4j配置
@MapperScan("com.atguigu.educms.mapper")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class,args);
    }
}
