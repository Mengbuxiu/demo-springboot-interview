package com.thinkinjava.basic._10_7;

/**
 * @author Alin
 * @version 1.0
 * @description // 一个内部类被嵌套多少层并不重要,它可以完全访问外部类的所有成员
 * @date 2019/4/28 14:00
 */
class MNA {
    private void f(){}
    class A {
        private void g() {}
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}
public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A a = mna.new A();
        MNA.A.B b = a.new B();
        b.h();
    }
}
