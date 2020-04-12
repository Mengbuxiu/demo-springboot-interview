package com.java.book.java_network_programing._4._10;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Alin
 * @desc //处理web服务器日志文件
 * @date 2020/4/9
 */
public class WebBlog {
    public static void main(String[] args) {
        try (final FileInputStream fin = new FileInputStream(args[0]);
        final InputStreamReader in = new InputStreamReader(fin);
        BufferedReader bin = new BufferedReader(in)) {

            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                final int index = entry.indexOf(" ");
                final String address = entry.substring(0, index);
                final String theRest = entry.substring(index);
                try {
                    InetAddress hostName = InetAddress.getByName(address);
                    System.out.println(hostName + " " + theRest);
                } catch (UnknownHostException e) {
                    System.out.println(entry);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
