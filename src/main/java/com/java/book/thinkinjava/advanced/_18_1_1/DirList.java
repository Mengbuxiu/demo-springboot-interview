package com.java.book.thinkinjava.advanced._18_1_1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author Alin
 * @desc // DirList 与 DirList2演示策略模式中匿名内部类的用法
 * @date 2019/5/12
 */
public class DirList {
    public static void main(String[] args) {
        //"."是指获取当前项目的根目录
        File path = new File(".");
        String[] list;
        if (args.length == 0){
            list = path.list();
        }else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(Objects.requireNonNull(list), String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
class DirFilter implements FilenameFilter{
    private Pattern pattern;

    public DirFilter(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}