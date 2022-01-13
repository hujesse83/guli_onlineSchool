package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.po.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-13T17:02:04+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class EduCourseConverterImpl implements EduCourseConverter {

    @Override
    public EduCourse map(CourseInfoVo courseInfoVo) {
        if ( courseInfoVo == null ) {
            return null;
        }

        EduCourse eduCourse = new EduCourse();

        eduCourse.setId( courseInfoVo.getId() );
        eduCourse.setTeacherId( courseInfoVo.getTeacherId() );
        eduCourse.setSubjectId( courseInfoVo.getSubjectId() );
        eduCourse.setSubjectParentId( courseInfoVo.getSubjectParentId() );
        eduCourse.setTitle( courseInfoVo.getTitle() );
        eduCourse.setPrice( courseInfoVo.getPrice() );
        eduCourse.setLessonNum( courseInfoVo.getLessonNum() );
        eduCourse.setCover( courseInfoVo.getCover() );

        return eduCourse;
    }

    @Override
    public List<EduCourse> map(List<CourseInfoVo> courseInfoVo) {
        if ( courseInfoVo == null ) {
            return null;
        }

        List<EduCourse> list = new ArrayList<EduCourse>( courseInfoVo.size() );
        for ( CourseInfoVo courseInfoVo1 : courseInfoVo ) {
            list.add( map( courseInfoVo1 ) );
        }

        return list;
    }

    @Override
    public CourseInfoVo map(EduCourse courseInfoVo) {
        if ( courseInfoVo == null ) {
            return null;
        }

        CourseInfoVo courseInfoVo1 = new CourseInfoVo();

        courseInfoVo1.setId( courseInfoVo.getId() );
        courseInfoVo1.setTeacherId( courseInfoVo.getTeacherId() );
        courseInfoVo1.setSubjectId( courseInfoVo.getSubjectId() );
        courseInfoVo1.setSubjectParentId( courseInfoVo.getSubjectParentId() );
        courseInfoVo1.setTitle( courseInfoVo.getTitle() );
        courseInfoVo1.setPrice( courseInfoVo.getPrice() );
        courseInfoVo1.setLessonNum( courseInfoVo.getLessonNum() );
        courseInfoVo1.setCover( courseInfoVo.getCover() );

        return courseInfoVo1;
    }

    @Override
    public List<CourseInfoVo> mapList(List<EduCourse> courseInfoVo) {
        if ( courseInfoVo == null ) {
            return null;
        }

        List<CourseInfoVo> list = new ArrayList<CourseInfoVo>( courseInfoVo.size() );
        for ( EduCourse eduCourse : courseInfoVo ) {
            list.add( map( eduCourse ) );
        }

        return list;
    }
}
