package com.atguigu;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class easyExcelTest {
    public static void main(String[] args) {
        // 实现excel写操作
        /**
         * 1、设置写入文件夹地址和excel文件名称
         * 2、调用api
         */
        String path = "/Users/jhu/Documents/Book3.xlsx";
        List<ExcelEntity> list = new ArrayList<>();
        for (int i = 0; i <= 1314; i++) {
            ExcelEntity excel = new ExcelEntity();
            excel.setNo(i);
            excel.setName("LuvElly"+i);
            list.add(excel);
        }
        EasyExcel.write(path, ExcelEntity.class).sheet().doWrite(list);

    }
}
