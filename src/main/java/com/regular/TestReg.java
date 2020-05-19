package com.regular;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alin
 * @version 1.0
 * @description // regular learning
 * @date 2019/8/12 10:52
 */
class TestReg {
    /**
     * 判断是否含有特殊字符
     *
     * true为包含，false为不包含
     */
    @Test
    public void reg(){
        String regEx = "[ _`~!@#$%^&*()+=|{}':;,\\[\\].<>/?！￥…（）—【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher("哈哈哈");
        System.out.println(m.find());
    }

    @Test
    void simpleReg1(){
//        String reg = "[a-zA-Z][(0-9){1.}+(a-zA-Z)]{7,29}";
//        String reg = "([a-zA-Z]+[(a-zA-Z+\\d)]){6,28}";
//        String reg = "^[a-zA-Z]+$";
//        System.out.println("s".matches(reg));
        String pwd = "s1sssssss";
        if (!pwd.matches("[a-zA-Z]+\\d+[a-zA-Z]")) {
            System.out.println("密码中必须包含数字！");
        }
    }
    @Test
    void testString(){
        System.out.println("word".matches("\bword"));
        System.out.println("abc".matches("^abc"));
    }
    @Test
    void testNum(){
        System.out.println("11456111".matches("^\\d{8}$"));
    }
    @Test
    void testZhuanYi(){
        System.out.println("ab".matches("^(ab)*$"));
    }
    @Test
    void testPhoneNum(){

        // 匹配 以 130|131|132|155|156|185|186|145|176 开头的手机号
        System.out.println("13011211000".matches("^(130|131|132|155|156|185|186|145|176)\\d{8}$"));
        System.out.println("13011211000".matches("^((13[0-2])|(15[56])|(18[5-6])|145|176)\\d{8}$"));
    }

    // 零宽断言
        // 正向先行断言
    @Test
    void test1() {
        String reg = "\\d+(?=</span>)";
        String test = "<span class=\"read-count\">阅读数：641</span>";
        Matcher mc = Pattern.compile(test).matcher(reg);
        while (mc.find()) {
            System.out.println("结果：" + mc.group()   );
        }
    }
}
