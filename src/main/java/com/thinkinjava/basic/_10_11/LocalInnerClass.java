package com.thinkinjava.basic._10_11;

import static java.lang.System.*;
/**
 * @author Alin
 * @version 1.0
 * @description // 局部内部类用法典型范例
 * @date 2019/4/29 14:36
 */
interface Counter{
    int next();
}
public class LocalInnerClass {
    private int count = 0;
    private Counter getCount_1(final String name){
        class CounterImpl implements Counter {
            private CounterImpl(){
                out.println("CounterImpl() ");
            }

            @Override
            public int next() {
                out.print(name);
                return count++;
            }
        }
        return new CounterImpl();
    }
    private Counter getCount_2(final String name){
        class CounterImpl2 implements Counter {
            private CounterImpl2(){
                out.println("CounterImpl2() ");
            }

            @Override
            public int next() {
                out.print(name);
                return count++;
            }
        }
        return new CounterImpl2();
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        Counter count_1 = localInnerClass.getCount_1("local inner "),
                count_2 = localInnerClass.getCount_2("anonymous inner ");

        for (int i = 0; i < 5; i++) {
            out.print(count_1.next() +"\n");
        }
        for (int i = 0; i < 5; i++) {
            out.print(count_2.next() +"\n");
        }
    }
}
