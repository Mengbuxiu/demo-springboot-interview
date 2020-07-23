package com.interview.demo.高级.多线程.forkjoin.sum;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class SumArray {
    private static class SumTask extends RecursiveTask<Integer> {

        // 阈值
        private final static int THRESHOLD = MakeArray.ARRAY_LENGTH / 10;
        private int[] arr; //表示我们要实际统计的数组
        private int fromIndex;//开始统计的下标
        private int toIndex;//统计到哪里结束的下标

        public SumTask(int[] arr, int fromIndex, int toIndex) {
            this.arr = arr;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        @Override
        protected Integer compute() {
            /** 出口 */
            if (toIndex - fromIndex < THRESHOLD) {
                int count = 0;
                for (int i = fromIndex; i <= toIndex; i++) {
                    //SleepTools.ms(1);
                    count = count + arr[i];
                }
                return count;
            } else {
                /** 递归 */
                //fromIndex....mid....toIndex
                //1...................70....100
                int mid = (fromIndex + toIndex) / 2;
                SumTask left = new SumTask(arr, fromIndex, mid);
                SumTask right = new SumTask(arr, mid + 1, toIndex);
                invokeAll(left, right);
                return left.join() + right.join();
            }
        }
    }


    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        int[] arr = MakeArray.makeArray();

        SumTask innerFind = new SumTask(arr, 0, arr.length - 1);

        long start = System.currentTimeMillis();

        pool.invoke(innerFind);//同步调用
        System.out.println("Task is Running.....");

        System.out.println("The count is " + innerFind.join()
                + " spend time:" + (System.currentTimeMillis() - start) + "ms");

    }
}
