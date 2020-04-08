package com.java.book.thinkinjava.advanced._21_2._1;

/**
 * @author Alin
 * @desc //测试类
 * @date 2019/5/19
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        //非单独的线程驱动，使用的是main函数的主线程
        launch.run();
    }
}
