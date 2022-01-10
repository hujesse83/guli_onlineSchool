package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.po.EduCourseDescription;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-03
 */
public interface EduCourseDescriptionService extends IService<EduCourseDescription> {

    void removeByCourseId(String courseId);
}
