package com.atguigu.eduorder.service.impl;

import com.atguigu.eduorder.client.EduCourseClient;
import com.atguigu.eduorder.client.EduUcenterClient;
import com.atguigu.eduorder.entity.Order;
import com.atguigu.eduorder.mapper.OrderMapper;
import com.atguigu.eduorder.service.OrderService;
import com.atguigu.eduorder.utils.OrderNoUtil;
import com.atguigu.servicebase.entity.CourseOrder;
import com.atguigu.servicebase.entity.UcenterMemberOrder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-18
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private EduCourseClient eduCourseClient;

    @Autowired
    private EduUcenterClient eduUcenterClient;

    @Override
    public String createOrder(String courseId, String userId) {
        // 远程调用获取用户信息
        UcenterMemberOrder userInfoOrder = eduUcenterClient.getUserById(userId);
        System.out.println(userInfoOrder);
        System.out.println(userInfoOrder);
        System.out.println(userInfoOrder);

        // 远程调用获取课程信息
        CourseOrder courseInfo = eduCourseClient.getCourseInfo(courseId);
        System.out.println(courseInfo);
        System.out.println(courseInfo);
        System.out.println(courseInfo);

        // 创建order对象, 向对象里面设置需要的数据
        Order order = Order
                .builder()
                .orderNo(OrderNoUtil.getOrderNo())
                .courseId(courseId)
                .courseTitle(courseInfo.getTitle())
                .courseCover(courseInfo.getCover())
                .teacherName(courseInfo.getTeacherName())
                .totalFee(courseInfo.getPrice())
                .memberId(userId)
                .mobile(userInfoOrder.getMobile())
                .nickname(userInfoOrder.getNickname())
                .status(0) // 订单状态（0：没有支付 1 ：已经支付）
                .payType(1) // 微信支付
                .build();
        baseMapper.insert(order);
        return order.getOrderNo();
    }
}
