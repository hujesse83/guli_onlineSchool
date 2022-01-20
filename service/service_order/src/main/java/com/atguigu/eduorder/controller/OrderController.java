package com.atguigu.eduorder.controller;


import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;
import com.atguigu.eduorder.entity.Order;
import com.atguigu.eduorder.service.impl.OrderServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-18
 */
@RestController
@RequestMapping("/eduorder/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    // 生成订单
    @GetMapping("createOrder/{courseId}")
    public R saveOrder(@PathVariable("courseId") String courseId, HttpServletRequest request){
        String userId = JwtUtils.getMemberIdByJwtToken(request);
        String orderId = orderService.createOrder(courseId,userId);
        return R.ok().data("orderId",orderId);
    }

    //2 根据订单id查询订单信息
    @GetMapping("getOrderInfo/{orderId}")
    public R getOrderInfo(@PathVariable String orderId) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderId);
        Order order = orderService.getOne(wrapper);
        return R.ok().data("item",order);
    }

    // 根据课程和用户id查询订单中表的订单状态
    @GetMapping("/isBought/{courseId}/{memberId}")
    public Boolean isBought(@PathVariable String courseId,@PathVariable String memberId){
        return orderService.isBoughtCourse(courseId,memberId);
    }
}

