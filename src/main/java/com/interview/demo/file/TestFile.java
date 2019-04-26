package com.interview.demo.file;

import com.interview.demo.util.GlobalUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Alin
 * @version 1.0
 * @description // 在指定目录创建文件
 * @date 2019/4/26 10:52
 */
public class TestFile {
    public static void main(String[] args) {
        try {
            new FileOutputStream(new File("/1.txt"));
            new FileOutputStream(new File(GlobalUtil.getWebRootPath().replaceAll("WEB-INF/classes/","")+"/2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ok");
    }
}
