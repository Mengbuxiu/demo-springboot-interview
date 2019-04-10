package com.interview.demo.test;

public class TestSplit {
    public static void main(String[] args) {
        String ips = "1.1.1.1;";
        String[] split = ips.split(";");
        System.out.println(split.length);
        for (String s : split) {
            System.out.println(s);
        }
    }
}
