package com.java_feature.jdk8.lambda.learn_by_myself.function;

import com.java_feature.jdk8.lambda.interf.Function;
import org.junit.jupiter.api.Test;

/**
 * @author Alin
 * @version 1.0
 * @description // 扩展function用法
 * @date 2019/7/29 16:58
 */
class TestFun_2 {
    @Test
    void test() {
        // 对某个对象进行处理
        System.out.println(trim("\t\t\t\taaaaaaaaaaaaaaaaaaaaa", String::trim));
    }

    private static String trim(String str, Function<String, String> fun) {
        return fun.apply(str);
    }
}
