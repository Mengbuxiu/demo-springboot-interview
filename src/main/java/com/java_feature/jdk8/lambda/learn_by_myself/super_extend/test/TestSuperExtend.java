package com.java_feature.jdk8.lambda.learn_by_myself.super_extend.test;

import com.google.common.collect.Lists;
import com.java_feature.jdk8.lambda.learn_by_myself.super_extend.entity.Animal;
import com.java_feature.jdk8.lambda.learn_by_myself.super_extend.entity.Cat;
import com.java_feature.jdk8.lambda.learn_by_myself.super_extend.entity.TerrestrialAnimal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Alsrc
 * @version 1.0
 * @description // ? super ? extend
 * @date 2019/7/31 11:30
 * ? 通配符类型
 * <? super T>  表示包括T在内的任何T的父类
 * <? extends T>    表示包括T在内的任何T的子类
 * -----------------------------------------------------
 * extends 可用于的返回类型限定，不能用于参数类型限定。
 * super 可用于参数类型限定，不能用于返回类型限定。
 *
 * default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
 *         Objects.requireNonNull(before);
 *
 *         return (V v) -> {
 *             T res = before.apply(v);
 *             R apply = this.apply(res);
 *
 *             return apply;
 *         };
 *     }
 * ==================================
 * Function<? super V, ? extends T> before
 *      extends T 限定的是27行的返回结果
 *      super V   是对27行before.apply(v)输入的限定
 *
 * **************************************************
 * 记住PECS原则：生产者（Producer）使用extends，消费者（Consumer）使用super。
 * - 生产者使用extends
 * 如果你需要一个列表提供T类型的元素（即你想从列表中读取T类型的元素），你需要把这个列表声明成<? extends T>，比如List<? extends Integer>，因此你不能往该列表中添加任何元素。
 *
 * - 消费者使用super
 * 如果需要一个列表使用T类型的元素（即你想把T类型的元素加入到列表中），你需要把这个列表声明成<? super T>，比如List<? super Integer>，因此你不能保证从中读取到的元素的类型。
 *
 * - 即是生产者，也是消费者
 * 如果一个列表即要生产，又要消费，你不能使用泛型通配符声明列表，比如List<Integer>。
 */
class TestSuperExtend {
    @Test
    void testSuper(){
        //List<? extends TerrestrialAnimal> 表示 “具有任何从Fruit继承类型的列表”，编译器无法确定List所持有的类型，
        // 所以无法安全的向其中添加对象。可以添加null,因为null 可以表示任何类型。
        List<? extends TerrestrialAnimal> ex = Lists.newArrayList();
        ex.add(null);
//        error:
//        ex.add(new Cat());
//        ex.add(new Animal());
//        ex.add(new TerrestrialAnimal());
        //只能放入父类是 TerrestrialAnimal 的实例
        List<? super TerrestrialAnimal> sp = Lists.newArrayList();
        sp.add(new Cat());
//        sp.add(new Animal());


        // extends
//        checkExtends(new ArrayList<Animal>());
        checkExtends(new ArrayList<TerrestrialAnimal>());
        checkExtends(new ArrayList<Cat>());
        // super
        checkSuper(new ArrayList<TerrestrialAnimal>());
        checkSuper(new ArrayList<Animal>());
        checkSuper(new ArrayList<Object>());
    }

    @Test
    void copy(){

        List<Animal> src = new ArrayList<Animal>(){{
            add(new Cat());
            add(new TerrestrialAnimal());
        }};
        /** !!!!!  new ArrayList<Animal>(2) 只代表能容纳两个Animal实例，并不代表 size == 2  */
        // Animal[] animal = new Animal[src.size()]
        List<Animal> dest = new ArrayList<>(Arrays.asList(new Animal[src.size()]));
        Collections.copy(dest, src);
        dest.forEach(System.out::println);
    }


    private void checkSuper(List<? super TerrestrialAnimal> sp) {
    }

    private void checkExtends(List<? extends TerrestrialAnimal> sp) {

    }
}
