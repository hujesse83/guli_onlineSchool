package com.atguigu.eduservice.entity.em;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jesse.hu
 * @date 2022/1/17 17:33
 */
@Getter
@AllArgsConstructor
public enum CourseStatus {
    DRAFT("Draft"),
    NORMAL("Normal");
    private String value;
}
