package com.thinkinjava.basic._15_3.coffee;

/**
 * @author Alin
 * @version 1.0
 * @description // 公共父类
 * @date 2019/5/5 14:08
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
