package com.atguigu.eduorder.entity;

import java.math.BigDecimal;

import com.atguigu.servicebase.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author jesse.hu
 * @since 2022-01-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_order")
@ApiModel(value="Order对象", description="订单")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "课程id")
    private String courseId;

    @ApiModelProperty(value = "课程名称")
    private String courseTitle;

    @ApiModelProperty(value = "课程封面")
    private String courseCover;

    @ApiModelProperty(value = "讲师名称")
    private String teacherName;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员昵称")
    private String nickname;

    @ApiModelProperty(value = "会员手机")
    private String mobile;

    @ApiModelProperty(value = "订单金额（分）")
    private BigDecimal totalFee;

    @ApiModelProperty(value = "支付类型（1：微信 2：支付宝）")
    private Integer payType;

    @ApiModelProperty(value = "订单状态（0：未支付 1：已支付）")
    private Integer status;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    private Integer isDeleted;




}
