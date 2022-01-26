package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.po.EduComment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/26 21:02
 * @LeetCodeNo
 */
public interface EduCommentService extends IService<EduComment> {
    List<EduComment> getComment(Long courseId);
}
