package com.jeek_time.深入拆解java虚拟机.JVM如何处理异常;

/**
 * @author Alin
 * @desc // JVM如何处理异常？
 * @date 2020/4/15
 */
public class DealWithExceptionForJVM {
    public static void main(String[] args) {
        try {
            mayThrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mayThrowException() {
    }
}
