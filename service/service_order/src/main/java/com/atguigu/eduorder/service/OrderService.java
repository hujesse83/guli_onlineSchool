package com.atguigu.eduorder.service;

import com.atguigu.eduorder.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-18
 */
public interface OrderService extends IService<Order> {

    String createOrder(String courseId, String userId);
}
