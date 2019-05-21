package com.thinkinjava.advanced._21_2._2;

import com.thinkinjava.advanced._21_2._1.LiftOff;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/5/19
 */
public class BasicThreads {
    public static void main(String[] args) {
        //将任务描述转变为工作任务并start
        new Thread(new LiftOff()).start();
        // 注意控制台打印的数据结果，由一个线程开启另一个线程，
        // 两个线程会交替执行
        System.out.println("Waiting for Liftoff:");

    }
}
