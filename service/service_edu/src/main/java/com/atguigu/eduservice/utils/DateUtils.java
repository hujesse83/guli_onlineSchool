package com.atguigu.eduservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

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

