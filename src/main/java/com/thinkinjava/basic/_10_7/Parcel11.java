package com.thinkinjava.basic._10_7;

import com.thinkinjava.basic._10_5.Destination;
import com.thinkinjava.basic._10_6.Content;

/**
 * 什么时候需要嵌套类？
 *
 * 如果你想要创建某些公共代码，
 * 使得它们可以被某个接口的不同实现所共用，
 * 那么使用接口内部的嵌套类会显得很方便
 *
 * 不需要内部类对象和外部类对象之间有联系时
 * 嵌套类就像是一个静态方法，但它同时还有类的定义
 * @author Alin
 * @version 1.0
 * @description // 嵌套类
 * @date 2019/4/28 10:33
 *
 * 嵌套类意味：
 *
 * 1.要创建嵌套类的对象，并不需要其外围类的对象
 * 2.不能从嵌套类的对象中访问非静态的外围类对象
 * 3.嵌套类可以包含字段和方法，普通内部类不能
 */
public class Parcel11 {
    private static class ParcelContents implements Content {
        private int i = 11;
        @Override
        public Integer getValue() {
            return i;
        }
    }
    protected static class ParcelDestination
    implements Destination{
        private String label;
        private ParcelDestination(String whereTo){
            this.label = whereTo;
        }

        @Override
        public void go(String whereTo) {
            System.out.println("hello, " + whereTo);
        }
        public static void f(){}

        static int x = 110;

        static class AnthorLevel {
            public static void f(){}
            static int x = 110;
        }

    }
    public static Destination destination(String s){
        return new ParcelDestination(s);
    }
    public static Content content(){
        return new ParcelContents();
    }

    public static void main(String[] args) {
        content();
        destination("nerd");//hello 电脑迷
    }
}
