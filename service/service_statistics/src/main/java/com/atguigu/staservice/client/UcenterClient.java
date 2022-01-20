package com.atguigu.staservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jesse.hu
 * @date 2022/1/19 16:35
 */

// 要加完整路径... 小失误

@Component
@FeignClient("service-ucenter")
public interface UcenterClient {
    @GetMapping("/educenter/member/countRegister/{day}")
    Integer countRegister(@PathVariable("day") String day);
}
