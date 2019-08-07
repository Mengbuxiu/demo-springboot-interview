package com.interview.demo.pattern;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/8/6 12:34
 */
public class TestMain {
    public static void main(String[] args) {
        MySubject subject = new Person();
        subject.registerSubject(new Cat());
        subject.registerSubject(new Dog());
        // run
        subject.notifyObservers();
    }
}
