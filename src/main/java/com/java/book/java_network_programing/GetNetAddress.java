package com.java.book.java_network_programing;

import java.net.InetAddress;

public class GetNetAddress {
    public static void main(String[] args) {
        InetAddress address;
        try {
            address =InetAddress.getByName("www.x4x234x.com");
            System.out.println("Name:" + address.getHostName());
            System.out.println("Addr:" + address.getHostAddress());
            System.out.println(address.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
