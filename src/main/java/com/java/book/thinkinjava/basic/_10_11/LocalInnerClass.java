package com.java.book.thinkinjava.basic._10_11;

import static java.lang.System.*;
/**
 * @author Alin
 * @version 1.0
 * @description // 局部内部类用法典型范例(方法中创建并使用class)
 * @date 2019/4/29 14:36
 * Q:匿名内部类和局部内部类的区别？
 * A:看下面示例，
 * 局部内部类的名字在方法外不可见
 * 局部内部类比匿名内部类多了一个构造器，匿名内部类只能用于实例的初始化
 * 所以使用局部内部类而不使用匿名内部类的另一个原因就是，需要不止一个该内部类的对象
 */
interface Counter{
    int next();
}
public class LocalInnerClass {
    private int count = 0;

    /**
     * 局部内部类是先定义class，然后再去返回实例，如果以if来判断，就有可能返回多个实例
     * @param name
     * @return
     */
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

    /**
     * 匿名内部类必然值能返回一个实例
     * @param name
     * @return
     */
    Counter getCount_2(final String name){
        return new Counter(){
            {
                out.println("CounterImpl2() ");
            }
            public int next() {
                out.print(name);
                return count++;
            }
        };
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
