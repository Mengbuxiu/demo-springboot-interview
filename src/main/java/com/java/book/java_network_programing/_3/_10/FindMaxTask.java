package com.java.book.java_network_programing._3._10;

import java.util.concurrent.Callable;

/**
 * @author Alin
 * @desc // 子线程执行完毕后回调主线程，通知执行完毕
 * @date 2020/4/5
 */
public class FindMaxTask implements Callable<Integer> {
    private int[] data;
    private int start;
    private int end;

    public FindMaxTask() {
    }

    public FindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        // find the max number
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }
}
