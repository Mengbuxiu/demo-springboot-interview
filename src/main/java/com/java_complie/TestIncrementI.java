package com.java_complie;

/**
 * @author Alin
 * @version 1.0
 * @description //
 * @date 2019/8/5 15:09
 * 查看汇编
 * -server -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,*.main
 */
public class TestIncrementI {
    private static int i = 0;

    public static void main(String[] args) {
        System.out.println(++i);
    }
}
