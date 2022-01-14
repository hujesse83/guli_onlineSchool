package com.atguigu.educenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jesse.hu
 * @date 2022/1/14 15:31
 */
@Configuration
public class MybatisLogConfig {
    @Bean
    public MybatisSqlPrintInterceptor mybatisSqlPrintInterceptor() {
        return new MybatisSqlPrintInterceptor();
    }
}
