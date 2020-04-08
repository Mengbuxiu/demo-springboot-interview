package com.java.book.thinkinjava.basic._18_6_2;

import com.java.book.thinkinjava.basic._18_6_1.BufferedInputFile;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author Alin
 * @version 1.0
 * @description // 从内存读文件
 * @date 2019/5/14 17:30
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        String filename = "Z:\\work_soft\\idea_wp\\demo-springboot-interview\\src\\main\\java\\com\\thinkinjava\\basic\\_18_6_2\\MemoryInput.java";
        String read = BufferedInputFile.read(filename);
        StringReader in = new StringReader(read);
        int c;
        while (-1 != (c = in.read())) {
            System.out.print((char) c);
            /*if ('\n'== c) {
                System.out.println();
            }*/
        }
    }
}
