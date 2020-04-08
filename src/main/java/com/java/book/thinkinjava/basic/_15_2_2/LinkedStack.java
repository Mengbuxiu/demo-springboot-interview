package com.java.book.thinkinjava.basic._15_2_2;

/**
 * @author Alin
 * @version 1.0
 * @description // 非linkedlist的内部链式存储机制
 * @date 2019/5/5 10:59
 */
public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){item = null; next = null;}
        Node(U item, Node<U> next){
            this.item = item;
            this.next = next;
        }
        boolean end(){
            return item == null
                    && next == null;
        }
    }
    //End sentinel
    private Node<T> top = new Node<>();
    public void push(T item){
        top = new Node<>(item,top);
    }
    public T pop(){
        T result = top.item;
        if (!top.end()) {
            top = this.top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null) {
            System.out.println(s);
        }
    }
}
