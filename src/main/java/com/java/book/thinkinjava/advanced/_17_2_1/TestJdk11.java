package com.java.book.thinkinjava.advanced._17_2_1;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/5/9 14:02
 */
public class TestJdk11 {
    public static void main(String[] args) {
        cal();
    }

    private static void cal() {
        int index = 0;
        int i = 0;
        String[] arr = "a b c d e".split(" ");
        System.out.println(arr[index++]);
        System.out.println(arr[++i]);
    }
}
