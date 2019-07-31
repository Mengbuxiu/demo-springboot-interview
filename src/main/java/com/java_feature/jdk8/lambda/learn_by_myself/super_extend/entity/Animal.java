package com.java_feature.jdk8.lambda.learn_by_myself.super_extend.entity;

/**
 * @author Alin
 * @version 1.0
 * @description // 顶级
 * @date 2019/7/31 11:21
 */
public class Animal {
    @Override
    public String toString(){
        System.out.println(this.getClass().getName() + "顶级");
        return "animal";
    }
}
