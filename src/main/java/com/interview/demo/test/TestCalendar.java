package com.interview.demo.test;

import org.apache.tomcat.jni.Local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TestCalendar {
    public static void main(String[] args) {

        LocalDate now = LocalDate.parse("2019-01-31");
        System.out.println(now.getMonthValue());
        System.out.println(now.plusMonths(1));
        System.out.println(now.getDayOfMonth());
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
