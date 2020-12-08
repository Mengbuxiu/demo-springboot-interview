package com.didi.轮子怎么用.克隆;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Map;

class TestBeanUtils {
    public static void main(String[] args) {
        Person src = Person.builder().age(11).name("zl").build();
        Person target = new Person();
        BeanUtils.copyProperties(src, target);
        System.out.println(target);
        final HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1", "2");
        final Package p1 = Package.builder().map(objectObjectHashMap).build();
        final Package p2 = new Package();
        BeanUtils.copyProperties(p1, p2);
        System.out.println(p2);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    private static class Package {
        private Map<String, String> map;
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
