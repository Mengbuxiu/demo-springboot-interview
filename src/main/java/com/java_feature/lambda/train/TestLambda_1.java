package com.java_feature.lambda.train;

import com.google.common.collect.Lists;
import com.java_feature.lambda.entity.Person;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/4/29 19:28
 */
public class TestLambda_1 {

    public static final Consumer<Person> p = (p) -> p.setName("aaa");
    public static final Consumer<Person> PRINT = System.out::println;

    public static void main(String[] args) {
        ArrayList<Person> people = Lists.newArrayList(
          new Person("zl",1),new Person("pp",2)
        );
        people.forEach(PRINT);
        people.forEach(p);
        people.forEach(PRINT);
    }
}
