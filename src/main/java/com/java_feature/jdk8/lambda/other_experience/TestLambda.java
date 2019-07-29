package com.java_feature.jdk8.lambda.other_experience;


import com.java_feature.jdk8.lambda.other_experience.interf.Executor;
import com.java_feature.jdk8.lambda.other_experience.interf.NameChecker;
import com.java_feature.jdk8.lambda.other_experience.interf.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * lambda 实践
 *
 * @author king_zl
 */
public class TestLambda {
    public static void main(String[] args) {
        List<Person> guiltyPersons = Arrays.asList(
                new Person("san", "zhang", 13),
                new Person("si", "li", 13)
        );
//        checkAndExecute(guiltyPersons,
//                    p -> p.getLastName().startsWith("z"),
//                    p -> System.out.println(p.getFirstName()));
        /**
         * 第三版[最终版]，可以去掉static
         */
        guiltyPersons.stream()
                .filter(person -> person.getLastName().startsWith("z"))
                .forEach(System.out::println);
//                .forEach(person -> System.out.println(
//                        person.getLastName() +" "+ person.getFirstName()));
    }

    /**
     * 第二版，看着还可以，但是这里的foreach有点碍眼，再改一下
     *
     * @param personList
     * @param predicate
     * @param consumer
     */
    private static void checkAndExecute(List<Person> personList, Predicate<Person> predicate,
                                        Consumer<Person> consumer) {
        personList.forEach(p -> {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        });
//        for (Person p : personList) {
//            if (predicate.test(p)){
//                consumer.accept(p);
//            }
//        }
    }

    /**
     * 第一版，其实这里的两个接口可以用泛型抽象出来公共类
     *
     * @param personList
     * @param nameChecker
     * @param executor
     */
    private static void checkAndExecute(List<Person> personList, NameChecker nameChecker,
                                        Executor executor) {
        for (Person p : personList) {
            if (nameChecker.check(p)) {
                executor.execute(p);
            }
        }
    }
}
