package com.atguigu.educenter.event;

import com.atguigu.educenter.entity.em.ReportActionType;
import com.atguigu.educenter.entity.po.UcenterMember;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author jesse.hu
 * @date 2022/1/17 14:02
 */

@Data
@AllArgsConstructor
public class UcenterActivity {
    private long id;
    private ReportActionType type;
    private UcenterMember ucenterMember;
    private Date actionTime;
}
