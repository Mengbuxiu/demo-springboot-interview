package com.java_feature.tenum.person;

public class Palm implements PalmAction{
    private final String name;

    public Palm(String name) {
        this.name = name;
    }

    @Override
    public void clenched() {
        System.out.println(this.name + " --> 握紧 ");
        for (Finger finger : Finger.values()) {
            System.out.println("\t" + finger.getMsg() + bend);
        }
    }

    @Override
    public void release() {
        System.out.println(this.name + " --> 释放 ");
        for (Finger finger : Finger.values()) {
            System.out.println("\t" + finger.getMsg() + straight);
        }
    }
}
