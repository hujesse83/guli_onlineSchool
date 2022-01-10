package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.constants.ErrorCode;
import com.atguigu.eduservice.entity.ChapterVoTree;
import com.atguigu.eduservice.entity.po.EduChapter;
import com.atguigu.eduservice.entity.po.EduVideo;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.mapStruct.EduChapterConverter;
import com.atguigu.eduservice.mapStruct.EduCourseConverter;
import com.atguigu.eduservice.mapStruct.EduVideoConverter;
import com.atguigu.eduservice.mapper.EduChapterMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.servicebase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoServiceImpl eduVideoService;

    // 课程大纲列表，根据课程ID进行查询
    @Override
    public List<ChapterVoTree> getChapterVideoByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        //1、根据课程id查询课程里面所有的章节
        wrapper.eq("course_id", courseId);
        List<EduChapter> eduChapterList = baseMapper.selectList(wrapper);

        //2、根据课程id查询课程里面所有的小节
        QueryWrapper<EduVideo> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("course_id", courseId);
        List<EduVideo> eduVideoList = eduVideoService.list(wrapper1);

        List<ChapterVoTree> res = new ArrayList<>();
        //3、遍历查询章节list集合进行封装
        for (EduChapter eduChapter : eduChapterList) {
            ChapterVoTree item = EduChapterConverter.INSTANCE.map(eduChapter);
            res.add(item);
            ArrayList<ChapterVoTree> children = new ArrayList<>();
            for (EduVideo eduVideo : eduVideoList) {
                if (eduVideo.getChapterId().equals(eduChapter.getId())) {
                    ChapterVoTree childrenItem = EduVideoConverter.INSTANCE.map(eduVideo);
                    children.add(childrenItem);
                }
                item.setChildren(children);
            }
        }
        return res;
    }

    @Override
    public boolean deleteChapter(String chapterId) {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id",chapterId);
        int count = eduVideoService.count(wrapper);
        if (count >0){
            throw new GuliException(ErrorCode.ERROR_CODE,"不能删除该章节");
        }
        int res = baseMapper.deleteById(chapterId);
        return res>0;
    }

    @Override
    public void removeByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        this.remove(wrapper);
    }
}
