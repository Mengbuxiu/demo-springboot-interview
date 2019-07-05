package com.java_feature.jdk8.date;

import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/7/4 17:24
 */
public class TestDuration {
    @DurationUnit(ChronoUnit.SECONDS)
    private static final Duration sessionTimeout = Duration.ofSeconds(30);

    private static final Duration readTimeout = Duration.ofMillis(1000);

    public static void main(String[] args) {
        System.out.println(sessionTimeout);
        System.out.println(readTimeout);
    }
}
