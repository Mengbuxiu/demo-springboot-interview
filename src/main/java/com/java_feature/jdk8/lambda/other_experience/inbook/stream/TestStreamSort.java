package com.java_feature.jdk8.lambda.other_experience.inbook.stream;

import com.java_feature.tenum.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/8/13 16:25
 */
class TestStreamSort {
    @Test
    void testSort(){
        List<User> users = Arrays.asList(
                new User("z1", 11, "man"),
                new User("z5", 55, "man"),
                new User("z2", 33, "man"),
                new User("z3", 22, "man"),
                new User("z4", 99, "man")
        );
        List<User> users1=users.stream().sorted().collect(Collectors.toList());//自然序列
        users1.forEach(System.out::println);
        System.out.println("--------------------------------");
        List<User> users2=users.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());//逆序
        users2.forEach(System.out::println);
        System.out.println("--------------------------------");

        List<User> users3=users.stream().sorted(Comparator.comparing(User::getUsername)).collect(Collectors.toList());//根据name顺序
        users3.forEach(System.out::println);
        System.out.println("--------------------------------");

        List<User> users4=users.stream().sorted(Comparator.comparing(User::getUsername).reversed()).collect(Collectors.toList());//根据name逆序
        users4.forEach(System.out::println);
    }
}
