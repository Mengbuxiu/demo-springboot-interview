package com.interest_bug;

import com.java_feature.jdk8.lambda.entity.Person;

import java.util.ArrayList;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/7/4 17:58
 */
public class TestLIst1 {
    public static void main(String[] args) {
        ArrayList<Person> v = new ArrayList<Person>(){{
            add(new Person("A",1));
            add(new Person("B",2));
        }};
        changeVal(v);
        v.forEach(System.out::println);
    }

    private static void changeVal(ArrayList<Person> v) {
        for (Person person : v) {
            if ("A".equals(person.getName())){
                person.setName("AA");
            }
        }
    }
}
