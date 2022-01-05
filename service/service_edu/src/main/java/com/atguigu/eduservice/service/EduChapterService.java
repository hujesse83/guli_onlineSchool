package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.ChapterVoTree;
import com.atguigu.eduservice.entity.po.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-03
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVoTree> getChapterVideoByCourseId(String courseId);
}
