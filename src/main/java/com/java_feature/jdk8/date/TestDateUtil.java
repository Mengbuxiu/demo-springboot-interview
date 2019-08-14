package com.java_feature.jdk8.date;

import com.interview.demo.util.DateUtil;

import java.time.LocalDate;
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
        LocalDateTime localDateTime = DateUtil.parseLocalDateTime("2019-08-14 12:12:12");
        // error
//        LocalDate localDate = DateUtil.parseLocalDate("2019-08-14 12:12:12");
//        System.out.println(localDate);
//        System.out.println(localDateTime);
        LocalDateTime time = LocalDateTime.parse("2019-08-14 12:12:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(time.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
//        String tmp = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//        System.out.println(tmp);
//        LocalDateTime time = DateUtil.parseLocalDateTime("2019-04-16 13:00:00");
//        LocalDateTime time1 = time.plusHours(1);
//        System.out.println(time1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
