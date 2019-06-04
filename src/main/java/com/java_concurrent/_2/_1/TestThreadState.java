package com.java_concurrent._2._1;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/5/28
 * 线程
 */
public class TestThreadState {
    public static void main(String[] args) {
        StateThread stateThread = new StateThread();
        stateThread.start();
        // 调用stop不会出现TERMINATED状态，必须以在start()方法那行断点执行然后控制台终止才会出现
        // stateThread.stop();
        System.out.println(stateThread.getState());
    }
}
