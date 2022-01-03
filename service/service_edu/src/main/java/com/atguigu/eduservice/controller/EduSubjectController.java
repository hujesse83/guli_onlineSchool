package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduSubjectTree;
import com.atguigu.eduservice.service.impl.EduSubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-02
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    EduSubjectServiceImpl eduSubjectService;

    // 添加课程分类
    // 把文件上传过来，把文件内容读取出来
    @PostMapping("/addSubject")
    public R addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file);
        return R.ok();
    }
    // 课程分类树形显示
    @GetMapping("/getAllSubject")
    public R getAllSubject(){
        List<EduSubjectTree> list = eduSubjectService.getAllOneTwoSubject();
        return R.ok().data("list",list);
    }

}

