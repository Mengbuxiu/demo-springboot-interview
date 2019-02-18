package com.interview.demo.test;

import org.apache.tomcat.jni.Local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TestCalendar {
    public static void main(String[] args) {

        DayOfWeek dw = DayOfWeek.of(1);
        System.out.println(dw.getValue());
        System.out.println(dw.plus(1));
        final DayOfWeek[] values = DayOfWeek.values();
        System.out.println("--------");
        for (DayOfWeek day : values) {
            System.out.println(day);
        }
        // System.out.println(System.currentTimeMillis());
        //LocalDate now = LocalDate.parse("2019-01-31");
//        System.out.println(now.getMonthValue());
//        System.out.println(now.plusMonths(1));
//        System.out.println(now.getDayOfMonth());
        //日期相加
//        LocalDateTime localDateTime = now.plusDays(50);
//        System.out.println(localDateTime);
        //LocalDateTime months = now.plusMonths(12);
        // System.out.println(months.format(DateTimeFormatter
        //         .ofPattern("yyyy-MM-dd HH:mm:ss")
        //         .withLocale(Locale.CHINA)
        //));
    }
}
