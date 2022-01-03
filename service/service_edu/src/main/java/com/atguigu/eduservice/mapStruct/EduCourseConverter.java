package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.po.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface EduCourseConverter {
    EduCourseConverter INSTANCE = Mappers.getMapper(EduCourseConverter.class);
    // 相同的属性就不用写mapping了
    EduCourse map(CourseInfoVo courseInfoVo);
    List<EduCourse> map(List<CourseInfoVo> courseInfoVo);
}
