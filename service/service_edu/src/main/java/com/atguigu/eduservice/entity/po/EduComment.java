package com.atguigu.eduservice.entity.po;

import com.atguigu.servicebase.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author jesse.hu
 * @date 2022/1/26 21:00
 *
 * 使用comment组件会有多级评论不能显示问题, 所以我这里采用单级别评论.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EduComment对象", description="评论")
public class EduComment extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "课程id")
    private String courseId;

    @ApiModelProperty(value = "父id(回复)")
    @JsonSerialize(using = ToStringSerializer.class)
    private String parentId;

    @ApiModelProperty(value = "用户id")
    private String memberId;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Integer isDeleted;

}
