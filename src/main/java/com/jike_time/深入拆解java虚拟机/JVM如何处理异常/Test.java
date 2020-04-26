package com.jike_time.深入拆解java虚拟机.JVM如何处理异常;

/**
 * @author Alin
 * @desc //
 * @date 2020/4/15
 */
public class Test {
    public static void main(String[] args) {
       test();
    }

    private static void test() {
        String s3;
        try {
            s3 = "This is try";
            System.out.println(1/0);
        }catch (Exception e){
            s3 = "This is catch";
        }finally {
            s3 = "This is finally";
        }
        s3 = "This is exit";
        System.out.println(s3);
    }
}
