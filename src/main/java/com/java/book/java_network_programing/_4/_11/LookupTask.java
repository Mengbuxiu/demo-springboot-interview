package com.java.book.java_network_programing._4._11;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

/**
 * @author Alin
 * @desc //解析日志文件，查找一个地址，并把这个文件替换为相应的主机名
 * @date 2020/4/9
 */
public class LookupTask implements Callable<String> {
    private String line;

    public LookupTask() {
    }

    public LookupTask(String line) {
        this.line = line;
    }

    @Override
    public String call(){
        final int index = line.indexOf(" ");
        final String address = line.substring(0, index);
        final String theRest = line.substring(index);
        InetAddress hostName;
        try {
            hostName = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            return line;
        }
        return hostName + " " + theRest;
    }
}
