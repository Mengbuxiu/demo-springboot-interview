package com.java_feature.tenum.person;

import lombok.Getter;

@Getter
public enum Finger implements BendingAction {
    A(0, "大拇指"),
    B(1, "食指"),
    C(2, "中指"),
    D(3, "无名指"),
    E(4, "小拇指");

    private final int val;

    private final String msg;

    Finger(int val, String msg) {
        this.val = val;
        this.msg = msg;
    }

    @Override
    public void bend() {
        System.out.println(this.msg + " --> 弯曲 ");
    }
}
