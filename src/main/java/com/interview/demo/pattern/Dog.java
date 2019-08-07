package com.interview.demo.pattern;

/**
 * @author Alin
 * @version 1.0
 * @description // 观察者
 * @date 2019/8/6 12:34
 */
public class Dog implements Eat,MyObserver {
    @Override
    public void eat() {
        System.out.println(this.getClass().getName() + " : eat");
    }
    @Override
    public void run() {
        this.eat();
        System.out.println(this.getClass().getName() + " : run");
    }
}
