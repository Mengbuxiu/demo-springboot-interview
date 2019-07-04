package com.java_feature.jdk8.optional;

import com.java_feature.tenum.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

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
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize1 = DataSize.ofMegabytes(2);
    @Test
    void testSize(){
        // 输出结果都是byte，除非@DataSizeUnit指定
        DataSize dataSize = DataSize.ofMegabytes(1);

        System.out.println(Integer.valueOf(dataSize.toString().replace("B",""))/1024);
        System.out.println(Integer.valueOf(dataSize1.toString().replace("B",""))/1024);
    }
}
