package com.interview.demo.email;

import org.springframework.stereotype.Component;

@Component
public class HandleUncaughtExceptionResolver implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("线程异常终止： ");
        e.printStackTrace();
    }
}
