package com.atguigu.staservice.entity;

import com.atguigu.servicebase.entity.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 网站统计日数据
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="StatisticsDaily对象", description="网站统计日数据")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsDaily extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "统计日期")
    private String dateCalculated;

    @ApiModelProperty(value = "注册人数")
    private Integer registerNum;

    @ApiModelProperty(value = "登录人数")
    private Integer loginNum;

    @ApiModelProperty(value = "每日播放视频数")
    private Integer videoViewNum;

    @ApiModelProperty(value = "每日新增课程数")
    private Integer courseNum;

}
