package com.java.book.thinkinjava.basic._10_3;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/24 17:49
 */
public class DotNew {
    public class Inner{
        void p(){
            System.out.println("I'm fine");
        }
    }

    public static void main(String[] args) {
//        DotNew dn = new DotNew();
        Inner i = new DotNew().new Inner();
        i.p();
    }
}
