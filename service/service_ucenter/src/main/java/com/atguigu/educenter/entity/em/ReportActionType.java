package com.atguigu.educenter.entity.em;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author jesse.hu
 * @date 2022/1/17 14:02
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ReportActionType {
    SAVE_USER("Save User");
    private String value;
}
