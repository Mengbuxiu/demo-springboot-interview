package com.interview.demo.高级.多线程.原子类;

import java.util.concurrent.atomic.AtomicIntegerArray;


/**
 *类说明：
 */
public class AtomicArray {
    static int[] value = new int[] { 1, 2 };
    
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);
    
    public static void main(String[] args) {
    	ai.getAndSet(0, 3);
    	System.out.println(ai.get(0));
    	System.out.println(value[0]);

    }
}
