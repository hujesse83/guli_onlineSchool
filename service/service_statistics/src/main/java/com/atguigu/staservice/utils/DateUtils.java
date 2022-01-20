package com.atguigu.staservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jesse.hu
 * @date 2022/1/19 17:33
 */
public class DateUtils {
    public static String parseDateToStr(String localDate, Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(localDate);
        return simpleDateFormat.format(date);
    }
    public static String parseDateToStr(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }
}
