package com.java_feature.jdk8.lambda.other_experience.inbook.stream;

import com.java_feature.jdk8.lambda.other_experience.inbook.entity.Artist;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alin
 * @version 1.0
 * @description // for
 * @date 2019/5/31 13:38
 */
public class TestStream {
    private static List<Artist> artists;
    @BeforeAll
    static void init(){
         artists = Arrays.asList(new Artist("1", "1", "1"),
                new Artist("2", "2", "2"),
                new Artist("3", "3", "4"),
                new Artist("4", "14", "4"));
    }

    /**
     * 常规for操作
     */
    @Test
    void doFor(){
        for (Artist artist : artists) {
            if ("1".equals(artist.getName())){
                System.out.println(artist);
            }
        }
    }
    @Test
    void doStreamFor(){
       /* long count = artists.stream().filter(
                (art) -> {
                    if ("1".equals(art.getOrigin())) {
                        System.out.println(art);
                        return true;
                    }
                    return false;
                }).count(); */
        long count = artists.stream().filter(
                (art) -> "1".equals(art.getOrigin())).count();
        System.out.println(count);
    }
    @Test
    void doStreamOf(){
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
