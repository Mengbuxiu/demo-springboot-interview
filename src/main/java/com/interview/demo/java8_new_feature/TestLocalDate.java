package com.interview.demo.java8_new_feature;

import javax.crypto.Cipher;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusMonths(2);
        System.out.println(localDate.toString());
        Calendar calendar = Calendar.getInstance();
        LocalDateTime time = LocalDateTime.now();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(hour + ":");
        sb.append(minute + ":");
        sb.append(second + ":");
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .parse(localDate.toString()+sb.toString()));
            System.out.println(calendar.getTimeInMillis());//1553270400000
        } catch (ParseException e) {
            e.printStackTrace();
        }
        char[] a = new char[1024];
        String asdsad = String.valueOf(a);
        //Cipher
        // String date = "2019-01-21 23:32:32";
        //String trim = date.trim();
        //System.out.println(date);
        //System.out.println(trim);
        // String[] s = trim.split(" ");
        // for (String str : s) {
        //    System.out.println(str);
        // }
        // System.out.println(s[0]);
        //System.out.println(s.length);
//        System.out.println(ChronoUnit.MONTHS.between(
//                LocalDate.parse(LocalDate.now().toString()),
//                LocalDate.parse("2019-04-30")));
        //自动计算日期
        // LocalDate parse = LocalDate.parse("2019-01-27");
        //LocalDate parse = LocalDate.parse("2019-01-28");
//        LocalDate parse = LocalDate.parse("2019-01-29");
//        LocalDate localDate = parse.plusMonths(1);
//        System.out.println(localDate + " 23:59:59"); // 2019-02-28 23:59:59
//        long l = localDate.toEpochDay();
//        System.out.println(l);

//        System.out.println(System.currentTimeMillis());
//        LocalDateTime time = LocalDateTime.now();
//        System.out.println(time.getHour());
//        System.out.println(time.getMinute());
//        System.out.println(time.getSecond());
    }
}