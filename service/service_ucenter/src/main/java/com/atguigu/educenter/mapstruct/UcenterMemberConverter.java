package com.atguigu.educenter.mapstruct;

import com.atguigu.educenter.entity.po.UcenterMember;
import com.atguigu.servicebase.entity.UcenterMemberOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/18 14:37
 */
@Mapper
public interface UcenterMemberConverter {
    UcenterMemberConverter INSTANCE = Mappers.getMapper(UcenterMemberConverter.class);

    UcenterMemberOrder map(UcenterMember ucenterMember);

    List<UcenterMemberOrder> map(List<UcenterMember> ucenterMemberList);
}
