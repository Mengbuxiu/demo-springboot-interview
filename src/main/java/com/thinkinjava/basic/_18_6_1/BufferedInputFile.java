package com.thinkinjava.basic._18_6_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Alin
 * @version 1.0
 * @description // 常规操作:将文件按行读入缓冲区并打印
 * @date 2019/5/14 17:07
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s).append("\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String filename = "Z:\\work_soft\\idea_wp\\demo-springboot-interview\\src\\main\\java\\com\\thinkinjava\\basic\\_18_6_1\\BufferedInputFile.java";
        System.out.println(read(filename));
    }
}
