package com.interview.demo.stack_heap;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Alin
 * @version 1.0
 * @description // 堆溢出测试
 * @date 2019/6/26 9:55
 */
public class TestHeapOverFlow {
    private static final List<byte[]> BYTES = Lists.newArrayList();
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                byte[] b = new byte[_1M];
                //BYTES.add(b);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            //当前线程设置中断标记
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
