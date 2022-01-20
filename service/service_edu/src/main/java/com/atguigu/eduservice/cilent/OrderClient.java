package com.atguigu.eduservice.cilent;

import io.swagger.models.auth.In;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jesse.hu
 * @date 2022/1/19 14:49
 */
@Component
@FeignClient("service-order")
public interface OrderClient {
    @GetMapping("/eduorder/order/isBought/{courseId}/{memberId}")
    Boolean isBought(@PathVariable("courseId") String courseId, @PathVariable("memberId") String memberId);
}
