package com.interview.demo.signleton;

public class MySingleton {
    //内部类
    private static class MySingletonHandler {
        private static MySingleton ins = new MySingleton();
    }

    private MySingleton() {
    }

    public static MySingleton getIns() {
        return MySingletonHandler.ins;
    }
}