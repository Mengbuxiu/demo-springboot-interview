package com.didi.线上事故复盘.异步调用内部异常;

import java.util.concurrent.*;

/**
 * @author Alin
 * @desc //https://www.cnblogs.com/woooodlin/p/13991807.html
 * @date 2020/11/16
 */
public class MainThread {
    public static void main(String[] args) {
        //normal......
        // 模拟异步调用
        final ExecutorService pool = Executors.newSingleThreadExecutor();
        final Future<Integer> future = pool.submit(new AsyncCall());
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }
    private static class AsyncCall implements Callable<Integer> {

        @Override
        public Integer call() {
            System.out.println(1/0);
            return 1;
        }
    }
}
