package com.thinkinjava.advanced._21_3._1;

import net.sf.ehcache.search.aggregator.Count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alin
 * @version 1.0
 * @description // 消费者任务，检查偶数的有效性
 * @date 2019/5/24 21:18
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (0 != val % 2) {
                System.out.println(val + " %2 != 0");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
