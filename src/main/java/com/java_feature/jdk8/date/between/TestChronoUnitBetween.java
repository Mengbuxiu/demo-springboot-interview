package com.java_feature.jdk8.date.between;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author zhenglin
 * @desc
 * @date 2021/8/24 11:19 上午
 */
public class TestChronoUnitBetween {
    public static void main(String[] args) {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime custom = LocalDateTime.of(LocalDate.now(), LocalTime.of(now.getHour(), now.getMinute(), 1));
        final long between = ChronoUnit.MINUTES.between(custom, now);
        // 后面 - 前面 > 0, 则后面的时间晚
        System.out.println("between = " + between);
    }
}
