//package com.thinkinjava.basic._10_8;
//
//public class OuterClass {
//
//    static {
//        System.out.println("OutClass static load");
//    }
//
//    {
//        System.out.println("OutClass {} load");
//    }
//
//    static class InnerClass{
//
//        static {
//            System.out.println("InnerClass static load");
//        }
//
//        {
//            System.out.println("InnerClass {} load");
//        }
//
//
//        InnerClass(){
//            System.out.println("InnerClass Load");
//        }
//    }
//    OuterClass(){
//        System.out.println("OutClass load");
//    }
//
//    public static void main(String[] args) {
//        new OuterClass().new InnerClass();
//    }
//
//}