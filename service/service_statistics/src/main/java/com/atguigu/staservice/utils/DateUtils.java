package com.atguigu.staservice.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatSpecific);
        return simpleDateFormat.format(date);
    }
    private static final String dateFormat = "yyyy-MM-dd";
    private static final String dateFormatSpecific = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 在日期date上增加amount天 。
     *
     * @param date   处理的日期，非null
     * @param amount 要加的天数，可能为负数
     */
    public static Date addDays(Date date, int amount) {
        Calendar now =Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE,now.get(Calendar.DATE)+amount);
        return now.getTime();
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.formatDate(new Date()));
        System.out.println(DateUtils.formatDate(DateUtils.addDays(new Date(), -1)));
    }
}
