package com.java_feature.class_loader;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/5/8 17:36
 */
public class TestClassLoader {
    public static void main(String[] args) {
        System.out.println(TestClassLoader.class.getClassLoader());
        System.out.println(TestClassLoader.class.getClassLoader().getParent());
        System.out.println(TestClassLoader.class.getClassLoader().getParent().getParent());
    }
}
