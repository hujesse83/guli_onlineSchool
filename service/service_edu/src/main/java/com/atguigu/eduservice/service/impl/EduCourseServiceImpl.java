package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.constants.ErrorCode;
import com.atguigu.eduservice.entity.po.EduCourse;
import com.atguigu.eduservice.entity.po.EduCourseDescription;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.mapStruct.EduCourseConverter;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-03
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    EduCourseDescriptionServiceImpl eduCourseDescriptionService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        // 1、向课程表添加课程基本信息
        System.out.println(courseInfoVo);
        EduCourse eduCourse = EduCourseConverter.INSTANCE.map(courseInfoVo);
        int insert = baseMapper.insert(eduCourse);
        if (insert<=0) throw new GuliException(ErrorCode.ERROR_CODE,"课程添加失败");
        String id = eduCourse.getId(); // 同源策略. 二张表的id需要一致
        System.out.println(id);
        // 2、 向课程简介表添加课程简介
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(id);
        eduCourseDescriptionService.save(courseDescription);
        return id;
    }
}
