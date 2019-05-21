package com.jvm_feature._10_3;

/**
 * @author Alin
 * @version 1.0
 * @description // 你能答对几个？
 * @date 2019/5/21 9:33
 */
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long    g = 3L;
        System.out.println("(c == d) = " + (c == d));
        System.out.println("(e == f) = " + (e == f));
        System.out.println("(c == (a + b)) = " + (c == (a + b)));
        System.out.println("c.equals(a + b) = " + c.equals(a + b));
        System.out.println("(g == (a + b)) = " + (g == (a + b)));
        System.out.println("g.equals(a + b) = " + g.equals(a + b));
    }
}
