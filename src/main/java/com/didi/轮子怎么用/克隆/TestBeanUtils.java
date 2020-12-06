package com.didi.轮子怎么用.克隆;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

public class TestBeanUtils {
    public static void main(String[] args) {
        Person src = Person.builder().age(11).name("zl").build();
        Person target = new Person();
        BeanUtils.copyProperties(src, target);
        System.out.println(target);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    private static class Person {
        private String name;
        private Integer age;
    }
}
