package com.java_feature.break_scan;

/**
 * @author Alin
 * @version 1.0
 * @description // String.toUpperCase()
 * @date 2019/6/12 18:12
 */
public class TestBreaker {
    public static void main(String[] args) {
        scan:{
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j <= 5; j++) {
                    int res = i * j;
                    if (res == 30){
                        System.out.println(res);
                        //感觉和普通的跳出没区别
                        break scan;
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= 5; j++) {
                int res = i * j;
                if (res == 30){
                    System.out.println(res);
                    break;
                }
            }
        }
        /**
         *
         * 这是反编译的代码，基本没什么区别？或许可以从硬件的角度考虑解释下
         *
         * 还有一点就是 res这个同名的局部变量，被编译器优化为1个变量了。
         *
        int i;
        int j;
        int res;
        label42:
        for(i = 0; i < 10; ++i) {
            for(j = 0; j <= 5; ++j) {
                res = i * j;
                if (res == 30) {
                    System.out.println(res);
                    break label42;
                }
            }
        }

        for(i = 0; i < 10; ++i) {
            for(j = 0; j <= 5; ++j) {
                res = i * j;
                if (res == 30) {
                    System.out.println(res);
                    break;
                }
            }
        }*/
    }
}
