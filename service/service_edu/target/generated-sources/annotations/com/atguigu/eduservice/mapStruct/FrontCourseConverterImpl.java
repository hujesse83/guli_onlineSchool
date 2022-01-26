package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.vo.front.CourseWebVo;
import com.atguigu.servicebase.entity.CourseOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-26T14:55:33+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class FrontCourseConverterImpl implements FrontCourseConverter {

    @Override
    public CourseOrder map(CourseWebVo courseWebVo) {
        if ( courseWebVo == null ) {
            return null;
        }

        CourseOrder courseOrder = new CourseOrder();

        courseOrder.setId( courseWebVo.getId() );
        courseOrder.setTitle( courseWebVo.getTitle() );
        courseOrder.setPrice( courseWebVo.getPrice() );
        courseOrder.setLessonNum( courseWebVo.getLessonNum() );
        courseOrder.setCover( courseWebVo.getCover() );
        courseOrder.setBuyCount( courseWebVo.getBuyCount() );
        courseOrder.setViewCount( courseWebVo.getViewCount() );
        courseOrder.setDescription( courseWebVo.getDescription() );
        courseOrder.setTeacherId( courseWebVo.getTeacherId() );
        courseOrder.setTeacherName( courseWebVo.getTeacherName() );
        courseOrder.setIntro( courseWebVo.getIntro() );
        courseOrder.setAvatar( courseWebVo.getAvatar() );
        courseOrder.setSubjectLevelOneId( courseWebVo.getSubjectLevelOneId() );
        courseOrder.setSubjectLevelOne( courseWebVo.getSubjectLevelOne() );
        courseOrder.setSubjectLevelTwoId( courseWebVo.getSubjectLevelTwoId() );
        courseOrder.setSubjectLevelTwo( courseWebVo.getSubjectLevelTwo() );

        return courseOrder;
    }

    @Override
    public List<CourseOrder> map(List<CourseWebVo> courseWebVoList) {
        if ( courseWebVoList == null ) {
            return null;
        }

        List<CourseOrder> list = new ArrayList<CourseOrder>( courseWebVoList.size() );
        for ( CourseWebVo courseWebVo : courseWebVoList ) {
            list.add( map( courseWebVo ) );
        }

        return list;
    }
}
