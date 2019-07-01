package com.interest_bug;

/**
 * @author Alin
 * @version 1.0
 * @description // 自动拆箱null
 * @date 2019/7/1 11:02
 */
public class TestNPE {
    public static void main(String[] args) {
        int val = num();
    }

    private static int num() {
        Integer i = null;
        return i;
    }
}
