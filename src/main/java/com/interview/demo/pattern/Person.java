package com.interview.demo.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alin
 * @version 1.0
 * @description // 主题
 * @date 2019/8/6 12:34
 */
public class Person implements MySubject {
    private final List<MyObserver> observers = new ArrayList<>(10);
    @Override
    public void registerSubject(MyObserver o) {
        observers.add(o);
    }

    @Override
    public void removeSubject(MyObserver o) {
        if (observers.size() != 0){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (MyObserver observer : observers) {
            observer.run();
        }
    }
}
