package com.atguigu.eduservice.mapStruct;

import com.atguigu.eduservice.entity.EduSubjectTree;
import com.atguigu.eduservice.entity.po.EduSubject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EduObjectConverter {
    EduObjectConverter INSTANCE = Mappers.getMapper(EduObjectConverter.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title")
    })
    EduSubjectTree map(EduSubject eduSubject);
    List<EduSubjectTree> map(List<EduSubject> eduSubject);

}
