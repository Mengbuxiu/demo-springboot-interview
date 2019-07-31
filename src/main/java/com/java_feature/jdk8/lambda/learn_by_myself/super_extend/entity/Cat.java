package com.java_feature.jdk8.lambda.learn_by_myself.super_extend.entity;

/**
 * @author Alin
 * @version 1.0
 * @description // 猫🐱
 * @date 2019/7/31 11:29
 */
public class Cat extends TerrestrialAnimal {
    @Override
    public String toString() {
        System.out.println(this.getClass().getName() + " 猫🐱");
        return "Cat";
    }
}
