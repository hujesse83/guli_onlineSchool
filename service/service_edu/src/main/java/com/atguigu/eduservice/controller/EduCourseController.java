package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.service.impl.EduCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody  CourseInfoVo courseInfoVo){
        String s = eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId",s);
    }
}

