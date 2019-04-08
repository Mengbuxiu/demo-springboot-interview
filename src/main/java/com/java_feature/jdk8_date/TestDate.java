package com.java_feature.jdk8_date;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestDate {
    public static void main(String[] args) {
        //LocalDate now = LocalDate.now();
        /**
         *   TemporalAdjusters  时间调整者？ 常用功能如下
         * finding the first or last day of the month
         * finding the first day of next month
         * finding the first or last day of the year
         * finding the first day of next year
         * finding the first or last day-of-week within a month, such as "first Wednesday in June"
         * finding the next or previous day-of-week, such as "next Thursday"
         */
//        LocalDate days = now.with(TemporalAdjusters.lastDayOfMonth());
//        System.out.println(days);
//        System.out.println(days.minusDays(2));
        /**
         * 日期相加的示例
         */
        LocalDate dateOfBirth = LocalDate.of(2012,Month.MAY,14);
        LocalDate firstBirthday = dateOfBirth.plusYears(1);
        System.out.println("明年生日的日期："+firstBirthday);
    }


}