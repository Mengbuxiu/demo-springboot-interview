package com.java_feature.tenum.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alin
 * @desc //描述 年
 * @date 2019/4/13
 */
@Getter
public class DescYear {
    private String year;
    private String month;


    public DescYear() {
        this.year = String.valueOf(LocalDate.now().getYear());
        this.month = String.valueOf(LocalDate.now().getMonth());
    }

    @Getter
    public enum Season {
            Spring("WHITE", Arrays.asList(12,1,2)),
            Summer("GREEN", Arrays.asList(3,4,5)),
            Autumn("RED", Arrays.asList(6,7,8)),
            WINTER("YELLOW", Arrays.asList(9,10,11));


        private String color;
        private List<Integer> monthList;

        public static String from(List<Integer> list,Integer m){
            for (Season season : Season.values()) {
                for (Integer integer : season.getMonthList()) {
                    for (Integer i : list) {
                        if (m.equals(i)) {
                            return season.getColor();
                        }
                    }
                }
            }
            return "";
        }

        public List<Integer> getMonthList() {
            return this.monthList;
        }

        Season(String color, List<Integer> month) {
            this.color = color;
            this.monthList = month;
        }
    }
}
