package com.java_feature.tenum;

import com.java_feature.tenum.entity.DescYear;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/4/13
 */
public class TestYear {
    public static void main(String[] args) {
        String month = new DescYear().getMonth();
        for (DescYear.Season season : DescYear.Season.values()) {
            List<Integer> monthList = season.getMonthList();
            System.out.println("DescYear.Season.from(monthList) = " + DescYear.Season.from(monthList, Integer.valueOf(month)));
            break;
        }
    }
}
