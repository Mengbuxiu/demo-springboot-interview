package com.interview.demo.try_catch_finally;

public class Test {
    private static int x = 1;
    private static int y = 1;
    private static int z = 1;

    public static void main(String[] args) {
        finallyValue();
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
    }

    private static int finallyValue() {
        try {
            return 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            //异常时finally也会执行
            return y++;
        } finally {
            System.out.println("finally");
            //finally 中 不能写return，这里return了try中的return就不执行了
            //return z++;
        }
    }
}
