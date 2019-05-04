package com.thinkinjava.basic._11_6_1;

import com.google.common.collect.Lists;
import com.java_feature.lambda.entity.Person;

import java.util.List;
import java.util.ListIterator;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/4/30 14:04
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Person> list = Lists.newArrayList(
                new Person("a", 1),
                new Person("b", 22),
                new Person("c", 333),
                new Person("d", 4444)
        );
        ListIterator<Person> it = list.listIterator();

//        while (it.hasNext()) {
//            it.next();
//            it.set(new Person("z",111));
//        }
        System.out.println("---------------------------------------------");


        while (it.hasNext()) {
            System.out.println(it.next() + "   " + it.nextIndex() + "   " + it.previousIndex());
        }
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
        /**
         * 从下标 1 开始遍历*/
        ListIterator<Person> it1 = list.listIterator(1);
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }
    }
}
