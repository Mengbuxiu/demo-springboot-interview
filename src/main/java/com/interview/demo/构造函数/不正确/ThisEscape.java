package com.interview.demo.构造函数.不正确;

public class ThisEscape {
    //当前类的私有变量
    private int num;
    //事件源类
    private static class EventSource {
        public void registerListener(EventListener eventListener){
            eventListener.onEvent(new Event());
           //sth
        }
    }
    //事件类
    private static class Event{
    }
    //时间监听类
    private interface EventListener{
         void onEvent(Event event);
    }
    //------------------------------------------------------------------
    //主要是这个构造方法。。。
    public ThisEscape(EventSource eventSource){
        eventSource.registerListener(event -> {
            // 这个num在我们匿名方法中在初始化对象钱就拿到了this，也拿到了没有初始化的num的值0。
            // 这样就会带来很大的风险。同时，这个也被称为不正确构造。
            // 这里，内部类实现中暴露了当前类的私有变量，而且是在初始化以前
            System.out.println("内部方法的num:"+num);
        });
        //继续初始化操作，给num赋值，然后构造方法结束
        num=10;
    }

    public static void main(String[] args) {
        ThisEscape threadTest7 = new ThisEscape(new EventSource());
        System.out.println("初始化完毕后的num:"+threadTest7.num);
    }
}
