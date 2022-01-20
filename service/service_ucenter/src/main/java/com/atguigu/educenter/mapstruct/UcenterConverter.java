package com.atguigu.educenter.mapstruct;

import com.atguigu.educenter.entity.po.UcenterMember;
import com.atguigu.educenter.entity.vo.UserLoginVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/14 14:58
 */
@Mapper
public interface UcenterConverter {
    UcenterConverter INSTANCE = Mappers.getMapper(UcenterConverter.class);

    UserLoginVo map(UcenterMember eduChapter);

    List<UserLoginVo> map(List<UcenterMember> eduChapterList);
}
