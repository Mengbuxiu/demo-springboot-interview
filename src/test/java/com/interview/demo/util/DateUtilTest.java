package com.interview.demo.util;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * <h2>关于日期的思考</h2>
 * <p>你如何确定现在现在是几点钟？</p>
 *
 * <p>首先要了解的是：我们身处银河系，地球绕太阳公转，而地球同时又在自转，太阳是不动的，
 *  动的是地球自身。
 *  同一时刻，太阳对地球上各经度的直射角度是不同的，比如在北京的人感觉太阳是直射地球的，
 *  而在新疆的人觉得太阳才刚刚升起，而美国的纽约可能还是深夜，
 *  按照经验我们给以上三个地区的人给一个大概时间：
 *  北京 - 12:00
 *  新疆 - 6：00
 *  纽约 - 0：00
 *  由此可见，想要知道你现在所在的地方是几点了，问题的重点不在于你是谁，而是你在哪
 *  由此即可引出一个概念：时区
 *  <a href="https://zh.wikipedia.org/wiki/File:World_Time_Zones_Map.png">协调世界时时区图</a>
 *  比如上海是
 *  <a href="https://zh.wikipedia.org/wiki/%E5%8D%8F%E8%B0%83%E4%B8%96%E7%95%8C%E6%97%B6">UTC+8:00</a>，
 *  代表上海处于东八区，
 *  也就是你处于哪个时区，那你现在就是几点</p>
 *  参考这两个类 {@link ZoneId} {@link ZoneOffset}
 *  <ul>
 *      <li> ZoneId指定时区标识符，并提供在Instant和LocalDateTime之间进行转换的规则。</li>
 *      <li> ZoneOffset指定与格林威治/UTC时间的时区偏移量。</li>
 *  </ul>
 */
class DateUtilTest {
    /**
     * 格林威治时间/ UTC时间的偏移量通常以小时为单位进行定义，但也有例外。
     * TimeZoneId示例中的以下代码 显示使用格林威治标准时间/ UTC的偏移量（未在整小时内定义）的所有时区的列表。
     */
    @Test
    void zone() {
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        LocalDateTime dt = LocalDateTime.now();

        // Create a List using the set of zones and sort it.
        List<String> zoneList = new ArrayList<>(allZones);
        Collections.sort(zoneList);

        for (String s : zoneList) {
            ZoneId zone = ZoneId.of(s);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
            String out = String.format("%35s %10s%n", zone, offset);

            // Write only time zones that do not have a whole hour offset
            // to standard out.
            if (secondsOfHour != 0) {
                System.out.println(out);
            }
        }
    }
    @Test
    void year() {
        boolean validLeapYear = Year.of(2021).isLeap();
        System.out.println(validLeapYear);
    }
    @Test
    void monthDay() {
        MonthDay date = MonthDay.of(Month.FEBRUARY, 29);
        //检查年份是否在该月日有效。
        boolean validLeapYear = date.isValidYear(2021);
        System.out.println("validLeapYear = " + validLeapYear);
    }
    @Test
    void yearMonth() {
        // YearMonth代表一年中的月份
        YearMonth date = YearMonth.now();
        System.out.printf("%s: %d%n", date, date.lengthOfMonth());

        YearMonth date2 = YearMonth.of(2020, Month.FEBRUARY);
        System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

        YearMonth date3 = YearMonth.of(2020, Month.MARCH);
        System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());
    }
    @Test
    void localDate() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 16);
        System.out.println(date);
        //获取下一个周三
        LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println(nextWed);

        // 获取指定日期是星期几
        DayOfWeek dotw = LocalDate.of(2020,Month.JANUARY,16).getDayOfWeek();
        System.out.println(dotw);
    }
    @Test
    void dayOfWeek() {
        System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));
        System.out.println();
        DayOfWeek dow = DayOfWeek.MONDAY;
        // Locale.ENGLISH
        Locale locale = Locale.getDefault();
        //获取当地环境的星期全名称，FULL、SHORT英文上有区别，中文没区别
        System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
        //...缩写名称
        System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
        //...短名称
        System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));
    }
    @Test
    void month() {
        System.out.printf("%d%n", Month.FEBRUARY.maxLength());
        System.out.println();
        Month month = Month.AUGUST;
        Locale locale = Locale.getDefault();
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));
        System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(month.getDisplayName(TextStyle.SHORT, locale));
    }
}