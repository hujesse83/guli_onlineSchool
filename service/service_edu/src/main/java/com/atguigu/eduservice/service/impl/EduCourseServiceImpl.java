package com.atguigu.eduservice.service.impl;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.constants.ErrorCode;
import com.atguigu.eduservice.entity.po.EduCourse;
import com.atguigu.eduservice.entity.po.EduCourseDescription;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.entity.vo.CourseQuery;
import com.atguigu.eduservice.mapStruct.EduCourseConverter;
import com.atguigu.eduservice.mapper.EduCourseMapper;
import com.atguigu.eduservice.service.EduCourseService;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

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

    @Autowired
    EduVideoServiceImpl eduVideoService;

    @Autowired
    EduChapterServiceImpl eduChapterService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {
        // 1、向课程表添加课程基本信息
        EduCourse eduCourse = EduCourseConverter.INSTANCE.map(courseInfoVo);
        int insert = baseMapper.insert(eduCourse);
        if (insert<=0) throw new GuliException(ErrorCode.ERROR_CODE,"课程添加失败");
        String id = eduCourse.getId(); // 同源策略. 二张表的id需要一致
        // 2、 向课程简介表添加课程简介
        EduCourseDescription courseDescription = new EduCourseDescription();
        courseDescription.setDescription(courseInfoVo.getDescription());
        courseDescription.setId(id);
        eduCourseDescriptionService.save(courseDescription);
        return id;
    }

    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        // 1、查询课程表
        EduCourse eduCourse = baseMapper.selectById(courseId);
        CourseInfoVo courseInfoVo = EduCourseConverter.INSTANCE.map(eduCourse);

        // 2、查询描述
        EduCourseDescription description = eduCourseDescriptionService.getById(courseId);
        courseInfoVo.setDescription(description.getDescription());
        return courseInfoVo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        //1、先修改课程表
        EduCourse eduCourse = EduCourseConverter.INSTANCE.map(courseInfoVo);
        int i = baseMapper.updateById(eduCourse);
        if (i==0){
            throw new GuliException(ErrorCode.ERROR_CODE,"修改课程信息失败");
        }
        // 2、再修改描述表
        EduCourseDescription description = new EduCourseDescription();
        description.setId(courseInfoVo.getId());
        description.setDescription(courseInfoVo.getDescription());
        eduCourseDescriptionService.updateById(description);
    }

    @Override
    public CoursePublishVo publishCourseInfo(String id) {
        return baseMapper.getPublishCourseInfo(id);
    }

    @Override
    public R queryCourseCondition(long current, long limit, CourseQuery courseQuery) {
        Page<EduCourse> eduCoursePage = new Page<>(current, limit);
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        String title = courseQuery.getTitle();
        String status = courseQuery.getStatus();
        if (StringUtils.hasLength(title)){
            queryWrapper.like("title",title);
        }
        if (StringUtils.hasLength(status)){
            queryWrapper.eq("status",status);
        }
        queryWrapper.orderByDesc("gmt_create","gmt_modified");
        Page<EduCourse> page = this.page(eduCoursePage, queryWrapper);
        List<EduCourse> records = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("rows", records).data("total", total);
    }

    /**
     * 1、根据课程ID删掉小节
     * 2、删除章节
     * 3、删除描述
     * 4、删除本身
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeCourse(String courseId) {
        eduVideoService.removeByCourseId(courseId);
        eduChapterService.removeByCourseId(courseId);
        eduCourseDescriptionService.removeByCourseId(courseId);
        boolean res = this.removeById(courseId);
        if (!res){
            throw new GuliException(ErrorCode.ERROR_CODE,"delete failed!");
        }
    }
}
