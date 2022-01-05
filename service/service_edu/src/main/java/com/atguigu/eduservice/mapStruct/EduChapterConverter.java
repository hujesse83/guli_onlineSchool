package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.ChapterVoTree;
import com.atguigu.eduservice.entity.po.EduChapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EduChapterConverter {
    EduChapterConverter INSTANCE = Mappers.getMapper(EduChapterConverter.class);

    // 相同的属性就不用写mapping了
    ChapterVoTree map(EduChapter eduChapter);
    List<ChapterVoTree> map(List<EduChapter> eduChapterList);
}
