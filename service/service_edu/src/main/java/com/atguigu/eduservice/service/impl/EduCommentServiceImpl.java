package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.po.EduComment;
import com.atguigu.eduservice.mapper.EduCommentMapper;
import com.atguigu.eduservice.service.EduCommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/26 21:03
 * @LeetCodeNo
 */
@Service
public class EduCommentServiceImpl extends ServiceImpl<EduCommentMapper, EduComment> implements EduCommentService {
    @Override
    public List<EduComment> getComment(Long courseId) {
        QueryWrapper<EduComment> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        wrapper.eq("parent_id", "0");
        return this.list(wrapper);
//        return comments.stream()
//                .filter(item -> Objects.equals(item.getParentId(), "0"))
//                .peek(item -> item.setChildren(commentRecursiveHelper(item, comments)))
//                .collect(Collectors.toList());
    }

    /**
     * stream 流递归太吊流
     private List<EduComment> commentRecursiveHelper(EduComment comment, List<EduComment> comments) {
     return comments.stream()
     .filter(item -> Objects.equals(item.getParentId(), comment.getId()))
     .peek(item -> item.setChildren(commentRecursiveHelper(item, comments)))
     .collect(Collectors.toList());
     }
     */
}
