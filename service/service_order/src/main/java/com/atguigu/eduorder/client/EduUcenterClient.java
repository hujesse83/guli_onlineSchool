package com.atguigu.eduorder.client;

import com.atguigu.servicebase.entity.CourseOrder;
import com.atguigu.servicebase.entity.UcenterMemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jesse.hu
 * @date 2022/1/18 14:50
 */
@Component
@FeignClient("service-ucenter")
public interface EduUcenterClient {
    @GetMapping("/educenter/member/getUserInfo/{id}")
    public UcenterMemberOrder getUserById(@PathVariable("id") String id);
}
