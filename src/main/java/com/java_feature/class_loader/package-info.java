package com.java_feature.class_loader;
/**
 * 目前我的jdk环境是11
 * 目前的ClassLoader加载顺序为
 * BootClassLoader -> PlatformClassLoader -> AppClassLoader
 *
 * jdk8是
 * BootClassLoader -> ExtClassLoader -> AppClassLoader
 *
 * Q:PlatformClassLoader 与 ExtClassLoader 的区别？
 * 1. PlatformClassLoader
 *      官方文档是这样描述的：
 *      The platform class loader, a unique type to make it easier to distinguish
 *      from the application class loader.
 *      平台类加载器，一个独特的类型使它更容易和应用程序类加载器区分，
 *      PlatformClassLoader(BootClassLoader parent) {
 *             super("platform", parent, null);
 *         }
 *      大概就是super里的这个platform了 >> 手动废弃
 *      为啥能让它特殊我也不知道，but
 *      震惊！private ClassLoader(Void unused, String name, ClassLoader parent)
 *      Void 竟然也是个类型！包装类！
 *
 *
 * 父加载器  爷爷级 <-爸爸级 <- 儿子级
 * BootClassLoader <- PlatformClassLoader <- AppClassLoader
 * 看起来好像 BootClassLoader 是最高级，但是运行以下代码就会发现
 *      public class TestClassLoader {
 *          public static void main(String[] args) {
 *              System.out.println(TestClassLoader.class.getClassLoader());
 *              System.out.println(TestClassLoader.class.getClassLoader().getParent());
 *              System.out.println(TestClassLoader.class.getClassLoader().getParent().getParent());
 *          }
 *      }
 *      // 输出结果：
 *      // jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc
 *      // jdk.internal.loader.ClassLoaders$PlatformClassLoader@4bbfb90a
 *      // null
 *      第三个值输出为null，why？
 */