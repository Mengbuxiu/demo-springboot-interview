package com.java_feature.lambda;

import com.java_feature.lambda.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestBiFunction {
    public static void main(String[] args) {
        List<Person> person = Arrays.asList(new Person("a",1),new Person("z",2));
        //getPersonByUserName("z",person).forEach(person1 -> System.out.println(person1.getName()));
        //getPersonByAge(1,person).forEach(person1 -> System.out.println(person1.getName()));
        commonPersonFilter("z", person, (name, p) ->
                p.stream().filter(per -> per.getName().equals(name)).collect(Collectors.toList())
        ).forEach(person1 -> System.out.println(person1.getName()));
    }

    /**
     * 函数式接口是一种更高度的抽象，对比下面两个方法就能看出这样写的好处，函数只负责处理传进来的逻辑，而不关心具体如何处理
     * 就像吃饭，嘴巴只负责吃进肚子，不用思考吃了啥
     * 由调用方定义具体的逻辑
     * @param name
     * @param person
     * @param biFunction
     * @return
     */
    private static List<Person> commonPersonFilter(String name,List<Person> person,BiFunction<String,List<Person>,List<Person>> biFunction){
        return biFunction.apply(name,person);
    }

    /**
     * 先定义了匿名函数的实现，再去调用实现
     * 还是写太死
     * @param age
     * @param personLists
     * @return
     */
    private static List<Person> getPersonByAge (Integer age, List<Person> personLists){
        BiFunction<Integer, List<Person>,List<Person>> biFunction = (ageOfPerson,person) -> {
            return personLists.stream()
                    .filter(personList -> personList.getAge() > ageOfPerson).collect(Collectors.toList());
        };
        return biFunction.apply(age,personLists);
    }

    /**
     * 这样写太死
     * @param name
     * @param personList
     * @return
     */
    private static List<Person> getPersonByUserName1(String name, List<Person> personList){
        Predicate<Person> personPredicate = n -> n.getName().equals(name);
        return personList.stream().filter(personPredicate).collect(Collectors.toList());
    }
}
