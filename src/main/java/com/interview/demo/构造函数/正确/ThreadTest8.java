package com.interview.demo.构造函数.正确;

public class ThreadTest8 {
    //当前类的私有变量
    private int num ;
    //使用final修饰
    private final EventListener listener;
    // 准备类
    private static class EventSource {
        public void registerListener(EventListener eventListener){
            eventListener.onEvent(new Event());
            System.out.println(eventListener);
            //sth
        }
    }
    // 准备类
    private static class Event{
    }
    // 准备类
    private interface EventListener{
         void onEvent(Event event);
    }
    //----------------------------------------------
     //主要是这个构造方法。。。
    //私有化构造方法
    //限定这个构造方法的作用域
    private ThreadTest8(){
        listener = new EventListener() {
            @Override
            public void onEvent(Event event) {
                //内部类实现中暴露了当前类的私有变量，但是作用域限制了当前类
                   System.out.println("内部方法的num:"+num);
            }
        };
        num = 10;
    }
    public static ThreadTest8 newInstance(EventSource eventSource){
        ThreadTest8 threadTest8 = new ThreadTest8();
        eventSource.registerListener(threadTest8.listener);
        return threadTest8;
    }
    public static void main(String[] args) {
        ThreadTest8 threadTest8 = newInstance(new EventSource());
        System.out.println("初始化完毕后的num:"+threadTest8.num);
    }
}