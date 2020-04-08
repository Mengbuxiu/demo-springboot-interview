package com.java.book.thinkinjava.basic._10_5;

/**
 * @author Alin
 * @version 1.0
 * @description // 方法内部类，也叫局部内部类
 * @date 2019/4/25 16:26
 */
public class Parcel5 {
    public Destination destination(String whereTo) {
        class PDestination implements Destination {
            private PDestination(String whereTo) {
                this.go(whereTo);
            }

            @Override
            public void go(String whereTo) {
                System.out.println("dest to = " + whereTo);
            }
        }
        return new PDestination(whereTo);
    }

    public static void main(String[] args) {
        //怎么感觉有点像流式调用比如stringBuilder.append(str).append(str)
        new Parcel5().destination("Beijing").go("sanlitun");
    }
}
