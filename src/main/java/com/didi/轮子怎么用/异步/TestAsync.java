package com.didi.轮子怎么用.异步;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author zhenglin
 *  
 * @desc
 * @date 2021/1/11 下午4:22
 */
class TestAsync {
    @Test
    void test01() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Future<Integer> submit = pool.submit(() -> {
            Thread.sleep(1000);
            return 100;
        });
        System.out.println("wait...");
        //只能通过阻塞或者轮询的方式得到任务的结果。
        System.out.println(submit.get());
    }
    @Test
    void test02() {
        /*
         CompletableFuture，提供了非常强大的Future的扩展功能，可以帮助我们简化异步编程的复杂性，
         提供了函数式编程的能力，可以通过回调的方式处理计算结果，并且提供了转换和组合CompletableFuture的方法。
         */
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1/0;
            return 100;
        });
        //future.join(); // CompletionException
        try {
            future.get(); // ExecutionException
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        // 外部调用 future.get()也会导致阻塞。
        return future;
    }
    @Test
    void test03() throws Exception {
        final CompletableFuture<Integer> f = compute();

        class Client extends Thread {
            private CompletableFuture<Integer> f;
            private Client(String threadName, CompletableFuture<Integer> f) {
                super(threadName);
                this.f = f;
            }
            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + f.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

        new Client("Client1", f).start();
        new Client("Client2", f).start();
        System.out.println("waiting");
        f.complete(100);
        //f.completeExceptionally(new Exception());
        System.in.read();
    }
    /**
     * 创建CompletableFuture对象
     *
     * public static CompletableFuture<Void> 	runAsync(Runnable runnable)
     *      默认使用ForkJoinPool.commonPool()
     * public static CompletableFuture<Void> 	runAsync(Runnable runnable, Executor executor)
     * public static <U> CompletableFuture<U> 	supplyAsync(Supplier<U> supplier)
     *      接收Supplier，所以有返回类型<U>
     * public static <U> CompletableFuture<U> 	supplyAsync(Supplier<U> supplier, Executor executor)
     *
     * 当CompletableFuture的计算结果完成，或者抛出异常的时候，我们可以执行特定的Action
     *
     * public CompletableFuture<T> 	whenComplete(BiConsumer<? super T,? super Throwable> action)
     *      接收BiConsumer，T是返回类型，另一个是异常，所以可以处理正常的计算结果，或者异常情况。
     * public CompletableFuture<T> 	whenCompleteAsync(BiConsumer<? super T,? super Throwable> action)
     * public CompletableFuture<T> 	whenCompleteAsync(BiConsumer<? super T,? super Throwable> action, Executor executor)
     * public CompletableFuture<T>     exceptionally(Function<Throwable,? extends T> fn)
     */

    private static long t = System.currentTimeMillis();
    int getMoreData() {
        Random rand = new Random();
        System.out.println("begin to start compute");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");
        return rand.nextInt(1000);
    }
    @Test
    void test04() throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(this::getMoreData);
        Future<Integer> f = future.whenComplete((v, e) -> {
            System.out.println(v);
            System.out.println(e);
        });
        System.out.println(f.get());
        System.in.read();
    }
}
