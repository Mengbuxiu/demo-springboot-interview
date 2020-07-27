package com.interview.demo.java8_new_feature;

import java.util.StringJoiner;

public class TestJoiner {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        final StringJoiner joiner = new StringJoiner(",");
        for (String s : arr) {
            joiner.add(s);
        }
        System.out.println(joiner);
    }
}
