package com.java_feature.jdk8.lambda.other_experience;


import com.java_feature.jdk8.lambda.other_experience.entity.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class AdvancedStreamingP2 {

    public static void main(String[] args) {

        List<Student> studentList = Student.generateData();
        collect(studentList);
        collectingAnd(studentList);
    }

    private static void collect(List<Student> studentList) {
        System.out.println("\n---------- Extracting Student Name with Max Age by Type -----------");
        Map<String, Optional<Student>> stuMax = studentList.stream().collect(groupingBy(Student::getType, maxBy(comparing(Student::getAge))));
        stuMax.forEach((k, v) -> System.out.println("Key : " + k + ", Value :" + v.get()));
    }

    /**
     * I want to extract the student name, with the max age, grouping student by Type. Is it possible by using any combination in "collect" itself?
     *
     * I want the output like :
     *
     * ---------- Extracting Student Name with Max Age by Type -----------
     *
     * Key : School, Value : Aman
     * Key : College, Value : Ajay
     */
    private static void collectingAnd(List<Student> studentList) {
        Map<String, String> stuMax =
                studentList.stream()
                        .collect(groupingBy(
                                Student::getType,
                                collectingAndThen(maxBy(comparing(Student::getAge)),v -> v.get().getName())
                        ));
        System.out.println(stuMax);
    }
}