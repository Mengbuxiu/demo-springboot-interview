package com.java.book.thinkinjava.basic._9_9;

/**
 * @author Alin
 * @version 1.0
 * @description // 工厂测试
 * @date 2019/4/25 14:36
 */
public class TestFactory {
    public static void main(String[] args) {
        serviceConsumer(new Implementation_1_Factory());
        serviceConsumer(new Implementation_2_Factory());
    }

    private static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method_1();
        service.method_2();
    }

}
