package com.interview.demo.高级.多线程.future;


import com.interview.demo.util.SleepTools;

import java.util.Random;
import java.util.concurrent.*;


/**
 * 类说明：演示Future等的使用
 */
public class UseFuture {

    /*实现Callable接口，允许有返回值*/
    private static class UseCallable implements Callable<Integer> {

        private int sum;

        @Override
        public Integer call() throws Exception {
            System.out.println("Callable子线程开始计算");
            Thread.sleep(1000);
            for (int i = 0; i < 5000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("中断成功, sum = " + sum);
                    return sum;
                }
                sum = sum + i;
            }
            System.out.println("Callable子线程计算完成，结果=" + sum);
            return sum;
        }

    }

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {

        UseCallable useCallable = new UseCallable();
//		FutureTask<Integer> futureTask = new FutureTask<>(useCallable);
        final ExecutorService pool = Executors.newSingleThreadExecutor();
        final Future<Integer> future = pool.submit(useCallable);
//		new Thread(futureTask).start();
        SleepTools.second(1);
//		if(r.nextBoolean()) {//随机决定是获得结果还是终止任务
        System.out.println("Get UseCallable result = " + future.get());
//		}else {
//			System.out.println("中断计算");
//			final boolean cancel = futureTask.cancel(true);
//			System.out.println("cancel = " + cancel);
//		}

    }

}
