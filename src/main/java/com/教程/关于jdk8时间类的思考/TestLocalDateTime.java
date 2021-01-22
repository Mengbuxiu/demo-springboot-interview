package com.教程.关于jdk8时间类的思考;

import org.apache.poi.ss.formula.functions.Now;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Alin
 * @desc //TODO
 * @date 2020/12/6
 */
public class TestLocalDateTime {
    @Test
    void test() {
        final ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        final ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime.toString());
    }
    @Test
    void test2(){
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        final Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.toEpochMilli());
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalTime.now());
    }
    @Test
    void test3(){
        final LocalDateTime localDateTime = LocalDateTime.now();
        final LocalDate localDate = LocalDate.now();
        final LocalTime localTime = LocalTime.now();
        final Instant instant = Instant.now();

        final LocalDate toLocalDate = localDateTime.toLocalDate();
        final LocalTime toLocalTime = localDateTime.toLocalTime();
        final long milli = localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
    @Test
    void test4(){
        final LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    @Test
    void test5(){
        final LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        final LocalDateTime with = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(with);
    }
}
