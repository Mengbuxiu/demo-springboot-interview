package com.interview.demo.波粒子;

import java.util.LinkedList;

interface LinkList {
    // time complexity less than O(n)
    // if value exists return true otherwise return false
    boolean isExists(Integer value);

    // time complexity less than O(n)
    void add(Node node);
}
class Node {
    Integer item;
    Node next;
    Node prev;

    Node(Node prev, Integer element, Node next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}

//------------
// Main class
//------------
class LinkListImpl implements LinkList {
    private Node head;
    private Node cur;

    @Override
    public boolean isExists(Integer value) {
        // 夹逼定则
        Node first = head;
        Node last = cur;
        while (first != null || last != null) {
            if (first.item.equals(value)) {
                return true;
            }else {
                // 移动指针
                first = first.next;
            }
            if (last.item.equals(value)) {
                return true;
            }else {
                last = last.prev;
            }
        }
        return false;
    }

    @Override
    public void add(Node newNode) {
        if (newNode == null) {
            throw new NullPointerException();
        }
        final Node l = cur;
        cur = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
    }
}

//----------
// unit test
//----------
// use: Junit4
// test function which you implement
class Test {
    // function: isExists and add
}