package com.interview.demo.util;

import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 * 
 * @author alin
 *
 */
public class DateUtil {
    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time){
        Assert.notNull(time, "time is null");
        //DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault()))
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault()));
    }

    /**
     * 将string 按指定格式转化为java.util.Date
     * 
     * @param str
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date str2Date(String str, String format)
            throws ParseException {
        if (str == null || "".equals(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return (Date) sdf.parse(str);
    }


    /** 获取时间戳 可用*/
    public static Long getMillis2() {
        return Instant.now().toEpochMilli();
    }
 
    /** LocalDateTime转时间戳 */
    public static Long localDateTime2Millis(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }
 
    /** LocalDate转时间戳 */
    public static Long localDate2Millis(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MIN).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }


    public static Long strToLong() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString()));
        return calendar.getTimeInMillis();
    }

    /**
     * yyyyMMddHHmmss
     */
    public static final DateTimeFormatter formatter_DateTimestamp = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter formatter_DateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前日期
     * 
     * @return
     */
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取当前时间
     * 
     * @return
     */
    public static LocalTime getLocalTime() {
        return LocalTime.now();
    }

    /**
     * 获取当前日期时间
     * 
     * @return
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前的毫秒数 可用
     * jdk11
     * @return
     */
    public static long getClockMillis() {
        Clock clock = Clock.systemDefaultZone();
        return clock.millis();
    }

    /**
     * 返回当前时间yyyyMMddHHmmss
     * 
     * @return
     */
    public static String getDateTimestamp() {
        return getLocalDateTime().format(formatter_DateTimestamp);
    }

    /**
     * 返回当前时间yyyy-MM-dd
     * 
     * @return
     */
    public static String getDate() {
        return getLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 返回当前系统时间 yyyy-MM-dd HH:mm:ss
     * 
     * @return 返回当前系统时间
     */
    public static String getDateTime() {
        return getLocalDateTime().format(formatter_DateTime);
    }

    /**
     * 获取当月第一天 yyyy-MM-dd
     * 
     * @return
     */
    public static String getFirstDayOfMonth() {
        return getLocalDate().withDayOfMonth(1).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取本月最后一天 yyyy-MM-dd
     * 
     * @return
     */
    public static String getLastDayOfMonth() {
        LocalDate localDate = getLocalDate();
        return localDate.withDayOfMonth(localDate.lengthOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 将yyyyMMddHHmmss转为 yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String formatDateTimestamp(String dateTimestamp) {
        return LocalDateTime.parse(dateTimestamp, formatter_DateTimestamp).format(formatter_DateTime);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss转为 yyyyMMddHHmmss
     */
    public static String formatDateTime(String dateTime) {
        return parseLocalDateTime(dateTime).format(formatter_DateTimestamp);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss转为 LocalDateTime
     */
    public static LocalDateTime parseLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, formatter_DateTime);
    }

    /**
     * 将yyyyMMddHHmmss转为 LocalDateTime
     */
    public static LocalDateTime parseLocalDateTimestamp(String dateTimestamp) {
        return LocalDateTime.parse(dateTimestamp, formatter_DateTimestamp);
    }

    /**
     * yyyy-MM-dd字符串转LocalDate
     * 
     * @param dateString
     * @return
     */
    public static LocalDate parseLocalDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * yyyy-MM-dd 增加日期
     * 
     * @param date
     * @param days
     * @return
     */
    public static String plusDays(String date, int days) {
        LocalDate localDate = parseLocalDate(date);
        return localDate.plusDays(days).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param startDate
     *            较小的时间 yyyy-MM-dd
     * @param endDate
     *            较大的时间 yyyy-MM-dd
     * @return 相差天数
     */
    public static int dateCompareTo(String startDate, String endDate) {
        LocalDate startLocalDate = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endLocalDate = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
        Period period = Period.between(startLocalDate, endLocalDate);
        return period.getDays();
    }
    public static LocalDateTime longToLocalDateTime(Long time) {
        return LocalDateTime.ofEpochSecond(time/1000,0, ZoneOffset.ofHours(8));
    }
}