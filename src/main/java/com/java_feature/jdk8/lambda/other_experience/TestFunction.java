package com.java_feature.jdk8.lambda.other_experience;


import com.java_feature.jdk8.lambda.other_experience.interf.Function;

/**
 * @author king_zl
 * @version 1.0
 * @description // lambda会改变我们的编程习惯: 传递值 -> 传递行为
 * @date 2019/4/10 17:03
 */
public class TestFunction {
    public static void main(String[] args) {
//        Function<String, Integer> num = Integer::parseInt;
////        Integer cal = 2;
////        compute(cal, num);
        System.out.println(cal1(2, v -> v * 3, v -> v * v));
        System.out.println(cal2(2, v -> v * 3, v -> v * v));
    }

    private static int cal1(int num, Function<Integer, Integer> fun1, Function<Integer, Integer> fun2) {
        //先执行fun2的动作，调用apply得到结果4，再和fun1组合，调用apply得到结果12
        //先计算 fun2.apply 再计算 fun1.apply
        return fun1.compose(fun2).apply(num);
    }

    private static int cal2(int num, Function<Integer, Integer> fun1, Function<Integer, Integer> fun2) {
        //先执行fun1的动作，调apply得到6，再调fun2的apply[做出动作]，得到结果36
        //先计算 fun1.apply 再计算 fun2.apply
        return fun1.andThen(fun2).apply(num);
    }

    private static void compute(Integer cal, Function<String, Integer> num) {
        System.out.println(num.apply("222") * 2);
    }

}
