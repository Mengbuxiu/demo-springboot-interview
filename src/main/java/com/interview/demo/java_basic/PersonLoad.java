package com.interview.demo.java_basic;

import lombok.Getter;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/22 13:22
 */
@Getter
public class PersonLoad {
    private String name = "Alin";
    public static final String country = "china";
    static {
        String father = "linBaBa";
        System.out.println("静态代码块： "+father);
    }
    {
        String mother = "linMam";
        System.out.println("代码块： "+mother);
    }
    PersonLoad(){}
    // 静态代码块 -> 构造函数 -> 成员变量 -> 代码块
}
