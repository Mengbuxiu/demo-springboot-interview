package com.interview.demo.email;

class ExceptionThread implements Runnable {
    @Override
    public void run() {
        //这里只能抛运行时异常，Runnable.run不允许抛出未处理的非运行时异常
        throw new RuntimeException("exception in new thread");
    }
}