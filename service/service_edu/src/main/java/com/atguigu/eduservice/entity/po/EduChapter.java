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
 * 课程
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="EduChapter对象", description="课程")
public class EduChapter extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程ID")
    private String courseId;

    @ApiModelProperty(value = "章节名称")
    private String title;

    @ApiModelProperty(value = "显示排序")
    private Integer sort;

}
