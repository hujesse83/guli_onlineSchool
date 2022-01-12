package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.po.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.entity.vo.CourseQuery;
import com.atguigu.eduservice.service.impl.EduCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-03
 */
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {
    @Autowired
    private EduCourseServiceImpl eduCourseService;

    @GetMapping()
    public R getCourse(){
        List<EduCourse> list = eduCourseService.list();
        return R.ok().data("list",list);
    }

    @PostMapping("/pageCourseCondition/{current}/{limit}")
    public R getPageCourseCondition(@PathVariable long current,
                                    @PathVariable long limit,
                                    @RequestBody(required = false) CourseQuery courseQuery){
        return eduCourseService.queryCourseCondition(current,limit,courseQuery);
    }

    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody  CourseInfoVo courseInfoVo){
        String s = eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId",s);
    }

    @GetMapping("/getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable String courseId){
        CourseInfoVo courseInfo = eduCourseService.getCourseInfo(courseId);
        System.out.println(courseInfo);
        return R.ok().data("courseInfoVo",courseInfo);
    }

    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    @GetMapping("/getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id){
       CoursePublishVo courseInfoVo =  eduCourseService.publishCourseInfo(id);
       return R.ok().data("publishCourse",courseInfoVo);
    }
    // 发布最终课程
    @PostMapping("/publishCourse/{id}")
    public R publishCourse(@PathVariable String id){
        EduCourse eduCourse = eduCourseService.getById(id);
        eduCourse.setStatus("Normal");
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }
    @DeleteMapping("/delete/{courseId}")
    public R deleteCourse(@PathVariable  String courseId){
        eduCourseService.removeCourse(courseId);
        return R.ok();
    }

}

