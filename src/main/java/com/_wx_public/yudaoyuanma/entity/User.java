package com._wx_public.yudaoyuanma.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author Administrator
 * @desc //TODO
 * @date 2019/4/27
 */
//支持链式调用
@Accessors(chain = true)
@Setter
@Getter
@ToString

/**用来创建对象
 * @RequiredArgsConstructor(staticName = "of")*/
public class User {
    private String userName;
    private Integer age;

//    public static void main(String[] args) {
//        User of = User.of();
//        System.out.println(of);
//    }
}
