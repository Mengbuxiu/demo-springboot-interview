package com.interview.demo.util;

/**
 * @author king_zl
 * @version 1.0
 * @description // 全局工具类
 * @date 2019/4/19 14:26
 */
public class GlobalUtil {
    public static String getWebRootPath() {
        return System.getProperties().getProperty("os.name").toLowerCase().contains("linux") ?
                GlobalUtil.class.getResource("/").toString().replace("file:", "")
                : GlobalUtil.class.getResource("/").toString().replace("file:/", "");
    }
}
