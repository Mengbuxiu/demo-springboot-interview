package com.thinkinjava.basic._9_9;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/4/25 14:33
 */
public class Implementation_1_Factory implements ServiceFactory{
    public Service getService(){
        return new Implementation_1();
    }
}
