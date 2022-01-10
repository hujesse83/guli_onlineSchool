package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.po.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-03
 */
public interface EduVideoService extends IService<EduVideo> {

    void removeByCourseId(String courseId);
}
