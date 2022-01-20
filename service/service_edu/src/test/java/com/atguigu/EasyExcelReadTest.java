package com.atguigu;

import com.alibaba.excel.EasyExcel;

public class EasyExcelReadTest {
    public static void main(String[] args) {
        // 实现读操作
        String path = "/Users/jhu/Documents/Book3.xlsx";
        EasyExcel.read(path,ExcelEntity.class,new ExcelListener()).sheet().doRead();
    }
}
