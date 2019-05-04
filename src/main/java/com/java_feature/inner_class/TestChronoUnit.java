package com.java_feature.inner_class;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TestChronoUnit {

    public static void main(String[] args) {
//        final DayOfWeek[] values = DayOfWeek.values();
//        System.out.println(values.length);//7
          YearMonth now = YearMonth.now();
 //       System.out.println(now.getMonthValue()); //1
        //System.out.println(now+"  "+now.lengthOfMonth());
        System.out.println(YearMonth.of(2019, 1));
        now.plus(1L,ChronoUnit.MONTHS);
        System.out.println(now);
    }

}
