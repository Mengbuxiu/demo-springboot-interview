package com.interview.demo.try_catch_finally;

public class Test {
    private static int x = 1;
    private static int y = 1;
    private static int z = 1;

    public static void main(String[] args) {
        int val = finallyValue();
        System.out.println("x = " + val);
        System.out.println("y = " + val);
        System.out.println("z = " + val);
    }

    private static int finallyValue() {
        try {
            return x++;
        } catch (Exception e) {
            e.printStackTrace();
            return y++;
        } finally {
            return z++;
        }
    }
}
