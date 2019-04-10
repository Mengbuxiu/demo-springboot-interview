package com.java_feature.lambda;

import java.util.function.Function;

/**
 * @author king_zl
 * @version 1.0
 * @description // lambda会改变我们的编程习惯: 传递值 -> 传递行为
 * @date 2019/4/10 17:03
 */
public class TestFunction {
    public static void main(String[] args) {
        Function<String,Integer> num = Integer::parseInt;
        Integer cal = 2;
        compute(cal, num);
    }

    private static void compute(Integer cal, Function<String, Integer> num) {
        System.out.println(num.apply("222") * 2);
    }
}
