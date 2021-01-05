package com.yl.localdate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @Author: 袁黎
 * @Date: 2020-10-29 14:48
 **/
public class MainClass {

    public static void main(String[] args) {
          //localDateTest();
     //   localTimeTest();
        localDateTimeTest();
    }


    private static void localDateTest(){
        // 获取当前日期
        LocalDate now = LocalDate.now();
        System.out.println(now); // 2020-10-29
        LocalDate localDate = now.plusYears(1L);
        System.out.println(localDate);

        
        // 设置日期
        LocalDate of = LocalDate.of(2020, 10, 29);
        System.out.println(of); // 2020-10-29

        // 获取年
        int year = of.getYear();
        System.out.println(year); // 2021
        // 获取月
        Month month = of.getMonth();
        System.out.println(month); // OCTOBER
        int i = of.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(i); // 10
        // 获取日
        int dayOfMonth = of.getDayOfMonth();
        System.out.println(dayOfMonth); // 29
        // 获取星期
        DayOfWeek dayOfWeek = of.getDayOfWeek();
        System.out.println(dayOfWeek);
        int i1 = of.get(ChronoField.DAY_OF_WEEK);
        System.out.println(i1);
    }
    
    
    private static void localTimeTest(){
        // 获取当前时间
        LocalTime now = LocalTime.now();
        System.out.println(now); // 15:14:54.412

        // 设置时间
        LocalTime of = LocalTime.of(15, 17, 32);

        // 获取小时
        int hour = of.getHour();
        System.out.println(hour); // 15
        int i = of.get(ChronoField.HOUR_OF_DAY);
        System.out.println(i); // 15

        // 获取分
        int minute = of.getMinute();
        System.out.println(minute); // 17
        int i1 = of.get(ChronoField.MINUTE_OF_HOUR);
        System.out.println(i1); // 17

        // 获取秒
        int second = of.getSecond();
        System.out.println(second); // 32
        int i2 = of.get(ChronoField.SECOND_OF_MINUTE);
        System.out.println(i2);

    }

    private static void localDateTimeTest(){

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // 2020-10-29T15:24:44.398


        //"yyyy-MM-dd HH:mm:ss"
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);

    }
    
}
