package com.java.book.thinkinjava.basic._10_9;

/**
 * @author Alin
 * @version 1.0
 * @description // 继承另一个类的内部类
 * @date 2019/4/29 9:41
 */
class WithInner{
    class Inner{
        void print(){
            System.out.println("innerclass");
        }
    }
}
public class InheritInner extends WithInner.Inner{
    /**
     * @param wi 此引用必传
     */
    InheritInner(WithInner wi){
        /**
         * 此条调用是必须的
         * 提供必要的引用
         */
        wi.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner inheritInner = new InheritInner(withInner);
        inheritInner.print();
    }
}
