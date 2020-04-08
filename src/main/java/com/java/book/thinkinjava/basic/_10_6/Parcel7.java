package com.java.book.thinkinjava.basic._10_6;


/**
 * @author Alin
 * @version 1.0
 * @description // 匿名内部类
 * @date 2019/4/26 14:02
 */
public class Parcel7 {
    public Content getContent(){
        return new Content(){
            private int i = 90;
            @Override
            public Integer getValue() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(new Parcel7().getContent().getValue());
    }
}
