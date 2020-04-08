package com.java.book.java_network_programing._3._10;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author Alin
 * @desc //TODO
 * @date 2020/4/5
 */
public class MultiThreadedMaxFinder {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Random random = new Random();
        final IntStream intsStream = random.ints(1000000);
        final int[] data = intsStream.toArray();
        System.out.println(data.length);
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(data));
        final FindMaxTask task1 = new FindMaxTask(data, 0, data.length / 2);
        final FindMaxTask task2 = new FindMaxTask(data, data.length / 2, data.length);
        final ExecutorService pool = Executors.newFixedThreadPool(2);
        final Future<Integer> future1 = pool.submit(task1);
        final Future<Integer> future2 = pool.submit(task2);
        System.out.println("max value is " + Math.max(future1.get(), future2.get()));
    }
}
