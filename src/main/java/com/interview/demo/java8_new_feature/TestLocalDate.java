package com.interview.demo.java8_new_feature;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestLocalDate {
    public static void main(String[] args) {
//        System.out.println(ChronoUnit.MONTHS.between(
//                LocalDate.parse(LocalDate.now().toString()),
//                LocalDate.parse("2019-04-30")));
        //自动计算日期
        LocalDate parse = LocalDate.parse("2019-01-31");
        LocalDate localDate = parse.plusMonths(1);
        System.out.println(localDate);
    }
}
