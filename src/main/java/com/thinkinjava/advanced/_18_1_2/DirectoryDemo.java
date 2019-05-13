package com.thinkinjava.advanced._18_1_2;

import java.io.File;

/**
 * @author Alin
 * @desc //使用Directory工具
 * @date 2019/5/13
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        for (File dir : Directory.walk(".").dirs) {
            System.out.println(dir);
        }
        System.out.println("----------------------------");
        for (File file : Directory.local(".", "T*.*")) {
            System.out.println(file);
        }
        System.out.println("----------------------------");
        for (File file : Directory.walk(".", "T.*\\.java")) {
            System.out.println(file);
        }
        System.out.println("----------------------------");
        for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
            System.out.println(file);
        }
    }
}
