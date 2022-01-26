package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.po.EduComment;
import com.atguigu.eduservice.service.EduCommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author HAN
 * @since 2021-05-01
 */
@RestController
@RequestMapping("/eduservice/edu-comment")
@Api(tags = "评论功能")
public class EduCommentController {

    @Autowired
    private EduCommentService eduCommentService;

    /**
     * 获取评论信息
     *
     * @param courseId 课程id
     */
    @GetMapping("{courseId}")
    @ApiOperation("获取评论")
    public R getComment(@PathVariable("courseId") Long courseId) {
        List<EduComment> commentList = eduCommentService.getComment(courseId);
        return R.ok().data("items", commentList);
    }

    /**
     * 添加评论信息
     *
     * @param comment 评论以及用户信息
     */
    @PostMapping("{courseId}")
    @ApiOperation("添加一级评论信息")
    public R saveCommentLevelOne(@RequestBody EduComment comment) {
        eduCommentService.save(comment);
        return R.ok();
    }


}