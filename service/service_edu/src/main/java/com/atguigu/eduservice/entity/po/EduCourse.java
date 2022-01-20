package com.atguigu.eduservice.entity.po;

import java.math.BigDecimal;

import com.atguigu.servicebase.entity.BaseEntityVersion;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EduCourse对象", description="课程")
public class EduCourse extends BaseEntityVersion implements Serializable {

    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "ID")
//    @TableId(value = "id", type = IdType.INPUT)  // 这里有点特别. 需要手动输入
//    private String id;

    @ApiModelProperty(value = "课程讲师ID")
    private String teacherId;

    @ApiModelProperty(value = "二级分类ID")
    private String subjectId;

    @ApiModelProperty(value = "一级分类ID")
    private String subjectParentId;

    @ApiModelProperty(value = "课程标题") //aka name
    private String title;

    @ApiModelProperty(value = "课程销售价格，设置为0则可免费观看")
    private BigDecimal price;

    @ApiModelProperty(value = "总课时")
    private Integer lessonNum;

    @ApiModelProperty(value = "课程封面图片路径")
    private String cover;

    @ApiModelProperty(value = "销售数量")
    private Long buyCount;

    @ApiModelProperty(value = "浏览数量")
    private Long viewCount;

    @ApiModelProperty(value = "课程状态 Draft未发布  Normal已发布")
    private String status;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableLogic
    private Integer isDeleted;

}
