package com.java.book.thinkinjava.basic._10_6;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/4/26 14:32
 */
public class Wrapping {
    private int x;
    public Wrapping(int x) {
        this.x = x;
    }

    protected int val() {
        return this.x;
    }
}
