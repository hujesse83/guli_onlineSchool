package com.atguigu.eduservice.entity.po;

import com.atguigu.servicebase.entity.BaseEntity;
import com.atguigu.servicebase.entity.BaseEntityVersion;
import com.baomidou.mybatisplus.annotation.*;


import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jesse.hu
 * @since 2021-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EduTeacher对象", description="讲师")
public class EduTeacher extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师简介")
    private String intro;

    @ApiModelProperty(value = "讲师资历")
    private String career;

    @ApiModelProperty(value = "头衔 1高级 2首席")
    private Integer level;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;

}
