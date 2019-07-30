package com.java_feature.jdk8.lambda.learn_by_myself.function;

import com.java_feature.jdk8.lambda.interf.Function;
import org.junit.jupiter.api.Test;

/**
 * @author Alin
 * @version 1.0
 * @description // 尝试一下设计复杂Function的功能
 * @date 2019/7/30 11:43
 */
@SuppressWarnings("unchecked")
class TestFun_3 {
    @Test
    void testPlayBasketball() {
//         打篮球三步上篮的过程
        // 1.运球
        // 2.迈步
        // 3.起跳
        // 4.投篮
//        "篮球三步上篮的过程篮球三步上篮的过程："
        /*      用 Function来实现一下       */
        final String[] str = {"我 -> "};
        Function<String, String> step_1 = (s) -> str[0] += "运球";
        Function<String, String> step_2 = (s) -> str[0] += "迈步";
        Function<String, String> step_3 = (s) -> str[0] += "起跳";
        Function<String, String> step_4 = (s) -> str[0] += "投篮";

        System.out.println(playBall(str, step_1, step_2, step_3, step_4));
    }

    private String playBall(String[] subject, Function<String, String>... step) {
        Function<String, String> head = step[0];
        for (Function<String, String> s : step) {
            // compose 可以变为倒序
            head = head.andThen(s);
        }
        return head.apply(subject[0]);
    }


}
