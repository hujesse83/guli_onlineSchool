package com.atguigu.servicebase.exceptionHandler;

import com.atguigu.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 作用时，增强controller
@RestControllerAdvice
@Slf4j // 可以写入日志文件
public class GlobalExceptionHandler {
    //   全局异常处理
    @ExceptionHandler(Exception.class)
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常");
    }
     //特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了特定异常处理");
    }
    // self designed exception
    @ExceptionHandler(GuliException.class)
    public R error(GuliException e){
        StackTraceElement traceElement = e.getStackTrace()[0];
        log.error(generateErrorInfo(traceElement));
        return R.error().code(e.getCode()).message(e.getMsg());
    }
    public String generateErrorInfo(StackTraceElement stackTraceElement){
        return "error occurs " + stackTraceElement.getClassName() +
                "class, in " + stackTraceElement.getMethodName() +
                "method in line number of " + stackTraceElement.getLineNumber();
    }
}
