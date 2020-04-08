package com.java.book.thinkinjava.basic._10_3;

/**
 * @author king_zl
 * @version 1.0
 * @description // 内部类中如何使用this
 * 如果你需要生成对外部类对象的引用，可以使用外部类.this
 * 如下所示
 * @date 2019/4/24 14:58
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }
    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
