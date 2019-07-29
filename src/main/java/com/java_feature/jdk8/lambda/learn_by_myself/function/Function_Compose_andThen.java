package com.java_feature.jdk8.lambda.learn_by_myself.function;

import com.java_feature.jdk8.lambda.interf.Function;
import org.junit.jupiter.api.Test;

/**
 * @author Alin
 * @version 1.0
 * @description // 对比 Compose andThen
 * @date 2019/7/29 13:45
 *
 * Function<String,Integer> fun1
 * Function<String,Integer> fun2
 * Function<String,Integer> fun3
 *
 * fun1.compose(fun2).compose(fun3) ......
 *
 * 总结：Function适用于各种函数功能的组合叠加，通过组合函数，会有更强大的功能函数产生
 */
class Function_Compose_andThen {
    @Test
    void test() {
        //传统计算乘法的方式
        mul(1,3,3);

    }
    @Test
    void test2(){
        mulCompose(1,inputVal -> inputVal * 3 , inputVal -> inputVal * inputVal);
    }
    @Test
    void test3(){
        mulAndThen(1,inputVal -> inputVal * 3 , inputVal -> inputVal * inputVal);
    }

    private static void mulAndThen(int inputVal, Function<Integer,Integer> fun_1,
                            Function<Integer,Integer> fun_2){
        // andThen 执行流程
        // 先前而后
        // andThen传入的行为不会马上执行，而是先执行调用andThen的fun_1中的apply()方法，拿到返回值 result
        // result = fun_1.apply(args)
        // 然后再对传入的行为执行apply
        // res = result.apply(result)
        Integer result = fun_1.andThen(fun_2).apply(inputVal);
        System.out.println(result);
    }



    private static void mulCompose(int inputVal, Function<Integer,Integer> fun_1,
                             Function<Integer,Integer> fun_2){
        // compose的执行流程
        // 看代码的意思似乎是 fun_1 先和 fun_2 组合，组合完了后返回apply(1)
        // 实际上是 compose 中fun_2先apply(1)，其返回值再与fun_1.apply[this.apply]
        // 也就是说：先执行 var result = compose(fun_2).apply(inputVal);
        //          然后   var res = fun_1.apply(result);
        //          res 就是最终结果
        // ----------------------------------------------
        //     ->  前是 传入的参数，   -> 后是 要做出的行为
        // ----------------------------------------------
        Integer result = fun_1.compose(fun_2).apply(inputVal);
        System.out.println(result);
    }
    private static void mul(int i, int i1, int i2) {
        System.out.println(i * i1 * i2);
    }
}
