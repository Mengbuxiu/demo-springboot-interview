package com.java_feature.jdk8.lambda.other_experience.interf;

import com.java_feature.jdk8.lambda.other_experience.entity.Person;

@FunctionalInterface
public interface Executor {
    void execute(Person p);
}
