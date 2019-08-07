package com.interview.demo.pattern;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/8/7 10:43
 */
public interface MySubject {
    void registerSubject(MyObserver o);
    void removeSubject(MyObserver o);
    void notifyObservers();
}
