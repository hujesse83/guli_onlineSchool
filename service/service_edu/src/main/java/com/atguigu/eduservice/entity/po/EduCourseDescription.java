package com.atguigu.eduservice.entity.po;

import com.atguigu.servicebase.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课程简介
 * 课程简介是text 类型 阿里规范 要提出来单独一张表 不然影响查询速度
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EduCourseDescription对象", description="课程简介")
public class EduCourseDescription extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程简介")
    private String description;




}
