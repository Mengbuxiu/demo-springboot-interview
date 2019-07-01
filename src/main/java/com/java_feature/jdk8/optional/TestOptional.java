package com.java_feature.jdk8.optional;

import com.java_feature.tenum.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author Alin
 * @version 1.0
 * @description // optional tests
 * @date 2019/7/1 14:49
 */
@Slf4j
class TestOptional {
    @Test
    void testOf(){
        User user = new User();
        String isGirl = Optional.of(user).map(User::getSex).orElse("girl");
        String isGirl1 = Optional.of(user).map(User::getSex).orElse("...");
        Integer age = Optional.of(user).map(User::getAge).orElse(1);
        System.out.println("age = " + age);
        System.out.println(isGirl);
        System.out.println(isGirl1);
    }
}
