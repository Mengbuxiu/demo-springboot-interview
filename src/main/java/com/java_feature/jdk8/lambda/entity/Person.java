package com.java_feature.jdk8.lambda.entity;

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
}
