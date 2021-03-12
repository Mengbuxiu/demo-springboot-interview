package com;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenglin
 *  
 * @desc
 * // 评测题目: 
 * // 编写程序，从本机的指定日志文件中读取日志，
 * //过滤出其中logType为A，且content中url对应的值的host为"www.taobao.com"的记录，
 * //然后对content中的count求和，输出最终结果。
 * // 日志位置: /home/admin/test.log
 * // 日志格式: logType^Acontent, 其中"^A"为不可见字符，对应ASCII码为001。
 * //如果读取到某行不符合该格式，则忽略此行记录。
 *
 * // 假定以下条件作为前提：
 * // 1. 程序对/home/admin/test.log有读权限
 * // 2. 当该行的logType=A时，content为json格式，当content中无法取得count时，认为count=0
 *
   举例，/home/admin/test.log 文件内容如下：
   A^A{"url":"http:www.baidu.com", "count": "1"}
   B^A{"count": 1, "other": ""}
   A^A{"url":"https:www.taobao.com", "count": "1"}
   A^A{"url":"http:www.taobao.com"}
 * // 执行完成后输出1。
 *
 * // 注意考虑日志和url形式的多样性
 * @date 2021/3/11 下午7:18
 */
public class SearchLog {
    public static void main(String[] args) throws IOException {
        // 1.读取文件
        // 2.逐行判断
        // 2.1 首字母 == 'A' && 第二字符的ASCII == '\\u001'
        // 2.2 json 转换
        // 2.3 解析url && count ，仅当同时不为null时生效
        // 2.4 判断url的后缀是否为“www.taobao.com”
        // 2.5 累加
        File file = new File("/Users/didi/admin/test.log");
        int line = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),
                    StandardCharsets.UTF_8));
            String lineTxt;
            while ((lineTxt = br.readLine()) != null) {
                System.out.println(lineTxt);
                if (lineTxt.startsWith("A")) {
//                    boolean equals = stringToAscii(lineTxt.substring(1, 3)).equals("^A");
                    String json = lineTxt.substring(3);
                    JSONObject jsonObject = JSONObject.parseObject(json);
                    String url = jsonObject.getString("url");
                    String count = jsonObject.getString("count");
                    if (StringUtils.hasText(url)
                            && url.endsWith("www.taobao.com")
                            && StringUtils.hasText(count)) {
                        line++;
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
        System.out.println("count = " + line);
    }


    public static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }
}
