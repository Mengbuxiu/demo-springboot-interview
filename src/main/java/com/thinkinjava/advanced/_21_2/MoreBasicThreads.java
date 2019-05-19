package com.thinkinjava.advanced._21_2;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/5/19
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for love:");
    }
}
