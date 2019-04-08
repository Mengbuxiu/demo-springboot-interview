package com.java_feature.learn_reflect;


import com.java_feature.learn_reflect.entity.Person;

import java.lang.reflect.Method;

import static com.java_feature.learn_reflect.TestReflect.E.A;

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //用给定的字符串name返回和类有关的对象或接口
        final Class<?> person = Class.forName("com.java_feature.learn_reflect.entity.Person");
        Class p = Person.class;
        System.out.println(p);
//        Class p1 = System.console().getClass();
//        System.out.println(p1);
        Class p2 = A.getClass();
        System.out.println(p2);
        byte[] bytes = new byte[1024];
        Class p3 = bytes.getClass();
        System.out.println(p3);
    }
    enum E {A,B};
}
