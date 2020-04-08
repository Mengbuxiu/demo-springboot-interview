package com.java.book.thinkinjava.basic._10_6;

/**
 * @author Alin
 * @version 1.0
 * @description // 链式调用demo
 * @date 2019/4/26 18:27
 */
public class Parcel7_1 {
    public interface Coder{
        Coder go(String dest);
    }

    public static Coder coder() {
        //相当于对接口做了个匿名类实现
        return new Coder() {
            @Override
            public Coder go(String dest) {
                System.out.println("next Dest: " + ("".equals(dest)? "no city":dest));
                return this;
            }
        };
    }

    public static void main(String[] args) {
        coder().go("北京").go("上海").go("杭州").go("");
    }
}
