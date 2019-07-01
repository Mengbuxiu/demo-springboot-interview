package com.java_feature.jdk8.lambda.interf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}
