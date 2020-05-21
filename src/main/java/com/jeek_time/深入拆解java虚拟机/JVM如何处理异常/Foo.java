package com.jeek_time.深入拆解java虚拟机.JVM如何处理异常;

public class Foo {
    private String tryBlock;
    private String catchBlock;
    private String finallyBlock;
    private String methodExit;

    public void test() {
        try {
            tryBlock = "tryBlock";
        } catch (Exception e) {
            catchBlock = "catchBlock";
        } finally {
            finallyBlock = "finallyBlock";
        }
        methodExit = "methodExit";
    }
}