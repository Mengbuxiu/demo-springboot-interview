package com.java_feature.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/10 16:27
 */
public class TestSort {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "q", "d", "s", "r", "y");
//        list.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
        //list.sort((o1, o2) -> o2.compareTo(o1));
        list.sort(Comparator.reverseOrder());

        list.forEach(System.out::println);
    }
}
