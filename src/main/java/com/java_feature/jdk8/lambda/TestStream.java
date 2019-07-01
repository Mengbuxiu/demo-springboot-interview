package com.java_feature.jdk8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author king_zl
 * @version 1.0
 * @description // lambda集合stream
 * @date 2019/4/10 12:53
 */
public class TestStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("zheng", "lin");
        //list.stream().map(item -> item.toUpperCase()).forEach(System.out::println);
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
