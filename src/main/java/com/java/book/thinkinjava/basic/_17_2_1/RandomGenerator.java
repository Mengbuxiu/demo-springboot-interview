package com.java.book.thinkinjava.basic._17_2_1;

import com.java.book.thinkinjava.basic._15_3.interf.Generator;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/5/9 14:52
 */
public class RandomGenerator {
    public static class Strings implements Generator<String> {
        private int length;
        private static final String ABC =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxytz";

        public Strings(int length){
            this.length = length;
        }

        @Override
        public String next() {
            //返回值的长度为index,随机在ABC中选取index个值
            String[] split = ABC.split("");
            return "";
        }
    }
}
