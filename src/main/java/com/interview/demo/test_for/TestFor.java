package com.interview.demo.test_for;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.ibm.com/developerworks/cn/java/j-introducing-junit5-part1-jupiter-api/index.html
 */
public class TestFor {
    /**
     * 被注解的方法将在当前类中的每个 @Test 方法前执行。
     * <=> junit 4 的@Before
     */

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>(3) {{
            add(1);
            add(2);
            add(3);
        }};

        for (Integer integer : list) {
            if (1 == integer)
                System.out.println(integer);
        }

        //list.forEach(System.out::println);
    }
}
