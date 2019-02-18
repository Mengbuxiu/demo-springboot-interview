package com.interview.demo.test;

import javax.validation.constraints.Null;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.temporal.TemporalField;

public class Test1 {
    public static void main(String[] args) {
       getNumber(1);
    }

    private static int getNumber(@Null int b) {
        int a = 1;
        try {
            return a;
        }catch (Exception e){
            a = -1;
        }finally {
            a = 30;
        }
        return a;
    }
}
