package com.java.book.thinkinjava.advanced._18_1_1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author Alin
 * @desc // 匿名内部类实现DirList
 * @date 2019/5/12
 * 创建一次性的类来解决某个问题，达成特定问题的代码隔离与聚拢，但不易阅读
 */
public class DirList2 {
    public static void main(String[] args) {
        //"."是指获取当前项目的根目录
        File path = new File(".");
        String[] list;
        if (args.length == 0){
            list = path.list();
        }else {
            //匿名内部类
            list = path.list(new FilenameFilter() {
                private Pattern pattern;
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(Objects.requireNonNull(list), String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
