package com.java_feature.jdk8.lambda.other_experience;

import com.java_feature.learn_reflect.entity.Person;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

/**
 * @author zhenglin
 * @desc
 * @date 2021/8/12 2:32 下午
 */
public class TestStreamAdvanced {
    @Test
    public void testFileStream() throws IOException {
        final Path path = Paths.get("/");
        final List<Path> pathList = Files.list(path).collect(Collectors.toList());
        pathList.forEach(System.out::println);

        // 递归访问
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            /**
             * 访问目录前触发
             * @param dir
             * @param attrs
             * @return
             * @throws IOException
             */
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("current dir is " + dir);
                System.out.println(attrs.creationTime());
                return super.preVisitDirectory(dir, attrs);
            }

            /**
             * 访问文件失败触发
             * @param file
             * @param exc
             * @return
             * @throws IOException
             */
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                exc.printStackTrace();
                return FileVisitResult.CONTINUE;
            }

            /**
             * 访问文件时触发
             * @param file
             * @param attrs
             * @return
             * @throws IOException
             */
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                return super.visitFile(file, attrs);
            }

            /**
             * 访问目录之后触发
             * @param dir
             * @param exc
             * @return
             * @throws IOException
             */
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }
        });
    }

    @Test
    public void testFlatMap() {
        String poetry = "Where, before me, are the ages that have gone?\n" +
                "And where, behind me, are the coming generations?\n" +
                "I think of heaven and earth, without limit, without end,\n" +
                "And I am all alone and my tears fall down.";
        Stream<String> lines = Arrays.stream(poetry.split("\n"));
        Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(" "))); // 传入的流处理并返回形成一个新的流
        List<String> l = words.map(w -> w.replaceAll("[,?.]", "").trim().toLowerCase())
                .distinct()
//                .sorted()
                .collect(Collectors.toList());
        System.out.println(l);
    }

    @Test
    public void testPeek() {
        final ArrayList<Person> people = new ArrayList<Person>() {{
            add(new Person("z1", 1));
            add(new Person("z2", 2));
            add(new Person("z3", 3));
            add(new Person("z4", 4));
        }};
        final List<Person> collect = people.stream()
                .peek(person -> person.setName(person.getName().toUpperCase()))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
    /**
     * 终止操作：
     *  Collectors.summarizingInt 汇总
     *  Collectors.partitioningBy 分区
     *  Collectors.groupingBy 分组
     *  Collectors.collectingAndThen 收集&然后do...
     *      TreeSet 可排序&根据指定值去重
     *  Collectors.groupingBy + Collectors.mapping
     *      组合功能：分组且对内指定值去重
     *  Collectors.joining() 拼接字符串
     */
    @Test
    public void testCollectors() {
        List<Person> people = new ArrayList<Person>() {{
            add(new Person("z1", 1));
            add(new Person("z2", 2));
            add(new Person("z2", 3));
            add(new Person("z4", 4));
            add(new Person("z4", 4));
            add(new Person("z5", 4));
        }};
        final Map<Boolean, List<Person>> partitioningBy = people.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 2));
        final Map<Integer, Long> groupingBy = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        final ArrayList<Person> collectingAndThen = people.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getAge))), ArrayList::new));
        // 分组且对内指定值去重
        final Map<Integer, Set<String>> groupingByAndMapping = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, toSet())));
        final String s = people.stream().map(Person::getName).collect(Collectors.joining());
    }
    @Test
    public void testReduce() {
        Optional<Integer> total = Stream.of(1,2,3,4,5).reduce(Integer::sum); // (x, y) -> x +y
        Integer total2 = Stream.of(1,2,3,4,5).reduce(0, Integer::sum); // (x, y) -> x +y，初始值累加
    }
}
