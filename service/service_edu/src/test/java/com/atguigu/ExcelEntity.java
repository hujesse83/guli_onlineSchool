package com.atguigu;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelEntity {
    // 设置excel表头名称
    @ExcelProperty(value = "编号",index = 0)
    private Integer no;
    @ExcelProperty(value = "名称",index = 1)
    private String name;
}
