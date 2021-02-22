package com.interview.demo.signleton;

public class MySingleton2 {
    private volatile MySingleton2 instance;

    public MySingleton2 getInstance() {
      synchronized (MySingleton2.class) {
        if (instance == null) {
          synchronized (MySingleton2.class) {
            if (instance == null)
              instance = new MySingleton2();
          }
        }
      }
        return instance;
    }
}