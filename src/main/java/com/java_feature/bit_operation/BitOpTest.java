package com.java_feature.bit_operation;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/15 16:13
 */
public class BitOpTest {
    public static void main(String[] args) throws UnknownHostException {
        String address = InetAddress.getLocalHost().getHostAddress();
        System.out.println("address = " + address);
        System.out.println("ipToLong(address) = " + ipToLong(address));

    }

    private static long ipToLong(String address) {
        String[] split = address.split("\\.");
        // return 后的 各值相加要带括号，不然结果为0
        return (Long.parseLong(split[0]) << 24)
                + (Long.parseLong(split[1]) << 16)
                + (Long.parseLong(split[2]) << 8)
                + (Long.parseLong(split[3]));
    }
}
