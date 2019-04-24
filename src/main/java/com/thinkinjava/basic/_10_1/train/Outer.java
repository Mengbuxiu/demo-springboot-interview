package com.thinkinjava.basic._10_1.train;

/**
 * @author Administrator
 * @desc //TODO
 * @date 2019/4/24
 */
public class Outer {
    private class Inner{
        Inner(String s){
            System.out.println("s = " + s);
        }
    }
    public Inner getInner(String s){
        return new Inner(s);
    }

    public static void main(String[] args) {
        Outer.Inner i = new Outer().getInner("私有内部类");
    }
}
