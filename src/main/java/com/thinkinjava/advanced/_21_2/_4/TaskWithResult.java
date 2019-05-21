package com.thinkinjava.advanced._21_2._4;

import java.util.concurrent.Callable;

/**
 * @author Alin
 * @desc //TODO
 * @date 2019/5/20
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
