package com.java_feature.jdk8.date;

import com.interview.demo.util.DateUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/16 11:16
 */
public class TestDateUtil {
    public static void main(String[] args) {
        System.out.println(DateUtil.getMillis2() == System.currentTimeMillis());
//        LocalDateTime time = DateUtil.parseLocalDateTime("2019-04-16 13:00:00");
//        LocalDateTime time1 = time.plusHours(1);
//        System.out.println(time1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
