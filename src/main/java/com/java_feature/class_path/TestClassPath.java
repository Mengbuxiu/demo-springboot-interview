package com.java_feature.class_path;

/**
 * @author Alin
 * @version 1.0
 * @description // ClassPath
 * @date 2019/5/8 16:25
 */
public class TestClassPath {
    public static void main(String[] args) {
        System.out.println(System.getProperty("jdk.internal.loader.ClassLoaders"));

        System.out.println("---------------------------------");
        String class_path = System.getProperty("java.class.path");
        String[] split = class_path.split(";");
        System.out.println("class_path : ");
        for (String s : split) {
            System.out.println(s);
        }
        String boot_path = System.getProperty("sun.boot.class.path");
        String ext_path = System.getProperty("java.ext.dirs");
        String vm_version = System.getProperty("java.version");
        System.out.println("---------------------------------");
        System.out.println("boot_path = " + boot_path);
        System.out.println("---------------------------------");
        System.out.println("ext_path = " + ext_path);
        System.out.println("---------------------------------");
        System.out.println("vm_version = " + vm_version);
    }
}
