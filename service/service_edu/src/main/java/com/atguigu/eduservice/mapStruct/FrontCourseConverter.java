package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.vo.front.CourseWebVo;
import com.atguigu.servicebase.entity.CourseOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/18 14:43
 */
@Mapper
public interface FrontCourseConverter {
    FrontCourseConverter INSTANCE = Mappers.getMapper(FrontCourseConverter.class);

    // 相同的属性就不用写mapping了
    CourseOrder map(CourseWebVo courseWebVo);
    List<CourseOrder> map(List<CourseWebVo> courseWebVoList);
}
