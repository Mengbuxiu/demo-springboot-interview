package com.interview.demo.RmiTest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
* Created by IntelliJ IDEA. 
* 客户端测试，在客户端调用远程对象上的远程方法，并返回结果。
*/ 
public class HelloClient { 
    public static void main(String args[]){ 
        try { 
            //在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
            IHello rhello =(IHello) Naming.lookup("rmi://localhost:8888/RHello");
            System.out.println(rhello.helloWorld()); 
            System.out.println(rhello.sayHelloToSomeBody("qqqqqqqqqqqqqqqqqqq"));
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace(); 
        }
    } 
}