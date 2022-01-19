package com.atguigu.eduservice.entity.vo;

import lombok.Data;

/**
 * @author jesse.hu
 * @date 2022/1/7 16:21
 */
@Data
public class CoursePublishVo {
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;
}
