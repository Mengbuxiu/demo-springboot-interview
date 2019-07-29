package com.java_feature.jdk8.lambda.other_experience.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String name;
    private Integer age;

    public Person(String san, String zhang, int i) {

    }

    public String getLastName() {
        return this.name;
    }
}
