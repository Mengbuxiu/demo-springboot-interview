package com.thinkinjava.advanced._21_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/5/20
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        /**
         * newCachedThreadPool可以方便的替换
         * */
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
