package com.interview.demo.static_and_final;

import com.java_feature.lambda.entity.Person;

import java.util.Arrays;

/**
 * @author Alin
 * @version 1.0
 * @description //
 * @date 2019/5/6 11:09
 *
 * final 修饰基本类型时代表这个基本类型的值是不可修改的，且必须要有初始值
 * final 修饰对象时，代表这个对象的引用地址是不可变的，即不可以指向其他对象,但可以被其他对象指
 *      查看下面被注释的示例
 *      且这个被final修饰的对象是可以被更新的[属性更新]
 *
 */
public class TestStaticFinal {
    private static int age = 0;
    private static final int[] ageArr = {1,2,3};
    private static final Person p = new Person("zz",11);

    public static void main(String[] args) {
        age = 1;
        System.out.println(Arrays.toString(ageArr));
        ageArr[1] = 111;
        System.out.println(Arrays.toString(ageArr));
        System.out.println(p);
        p.setAge(222);
        p.setName("Alin");
        System.out.println(p);
        Person person = p;
        System.out.println(person);
        //p = new Person("aa",222); //error
    }
}
