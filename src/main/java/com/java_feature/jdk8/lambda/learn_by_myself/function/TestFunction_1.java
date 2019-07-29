package com.java_feature.jdk8.lambda.learn_by_myself.function;


import com.java_feature.jdk8.lambda.interf.Function;
import org.junit.jupiter.api.Test;

/**
 * @author Alin
 * @version 1.0
 * @description // Function
 * @date 2019/7/29 13:12
 * @description 牢记！！  lambda传递的只是行为
 *  一个有趣的发现，将以下测试代码一起执行，可以发现的是
 *  只有add方法执行了8ms，而其余方法均执行2ms
 *  多次测试后，依然是 add 方法执行时间最长
 */
class TestFunction_1 {
    // 传统写法
    @Test
    void add() {
        add(2, 2);
    }

    /**
     * lambda写法
     */
    @Test
    void add1() {
        // 将行为1与行为2组合了，然后传入2并计算
        add1(2, x -> x + 2, x -> x);
    }

    /**
     * 2 3 等效
     */
    @Test
    void add2() {
        add2(2,x -> x + 2, x -> x + x);
    }

    @Test
    void add3() {
        add3(2, x -> x + 2);
    }

    private static void add3(int inputNum, Function<Integer, Integer> fun_1) {
        Integer result = fun_1.apply(inputNum);
        System.out.println(result + " --- add3");
    }

    private static void add2(int inputNum, Function<Integer, Integer> fun_1,
                             Function<Integer, Integer> fun_2) {
        Integer result = fun_1.apply(inputNum);
        System.out.println(result + " --- add2");
    }

    private static void add1(int inputNum, Function<Integer, Integer> fun_1,
                             Function<Integer, Integer> fun_2) {
        Integer result = fun_1.compose(fun_2).apply(inputNum);
        System.out.println(result + " --- add1");
    }

    private static void add(int a, int b) {
        System.out.println(a + b + " --- add");
    }
}
