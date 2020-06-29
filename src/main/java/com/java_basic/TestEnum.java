package com.java_basic;

/**
 * @author Alin
 * @desc //
 * @date 2020/5/11
 */
public class TestEnum {
    enum Num {
        one('a'), two('b'), three('c'), four('d');
        private char c;

        Num(char d) {
            this.c = d;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        System.out.println(Num.one.getC());
    }
}
