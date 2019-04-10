package com.interview.demo.test;

import javax.validation.constraints.Null;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer>  list = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(0);
            add(6);
        }};
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i) == 0){
                linkedList.remove(i);//removeIf,iteration，减少索引
                linkedList.add(i,100);
            }
        }

        list.forEach(System.out::println);
        linkedList.forEach(System.out::println);
    }


}
