package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.ChapterVoTree;
import com.atguigu.eduservice.entity.po.EduVideo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EduVideoConverter {
    EduVideoConverter INSTANCE = Mappers.getMapper(EduVideoConverter.class);

    // 相同的属性就不用写mapping了
    ChapterVoTree map(EduVideo eduVideo);
    List<ChapterVoTree> map(List<EduVideo> eduVideoList);
}
