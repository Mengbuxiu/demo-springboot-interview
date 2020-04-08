package com.java.book.thinkinjava.basic._10_6;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/4/26 14:29
 */
public class Parcel8 {
    public Wrapping wrapping(int x){
        return new Wrapping(x){
            public int val(int x) {
                return super.val() * x;
            }
        };
    }
}
