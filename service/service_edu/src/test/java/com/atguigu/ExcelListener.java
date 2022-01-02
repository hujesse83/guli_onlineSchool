package com.atguigu;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

public class ExcelListener extends AnalysisEventListener<ExcelEntity> {

    //一行一行的读取
    @Override
    public void invoke(ExcelEntity excelEntity, AnalysisContext analysisContext) {
        System.out.println("***");
        System.out.println(excelEntity);
        System.out.println("***");
    }

    // 读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头");
        System.out.println(headMap);
    }

    // 读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完成");
    }
}
