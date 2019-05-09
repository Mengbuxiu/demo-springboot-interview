package com.thinkinjava.basic._17_2_1;

import com.thinkinjava.basic._15_3.interf.Generator;

import java.util.ArrayList;

/**
 * 适配器类
 * @author Alin
 * @version 1.0
 * @description // 作为一个数据集合
 * @date 2019/5/9 13:21
 *
 * 适配器模式
 * Adapter（别名Wrapper）模式：将一个类的接口，转换成客户期望的另一个类的接口。
 *  -------------------> 适配器让原本接口不兼容的类可以合作无间。
 *  -------------------> [Generator:各型号的笔记本,CollectionData:电源适配器]
 *
 * 要点：
 * 1．适配器模式主要应用于“希望复用一些现存的类，但是接口又与复用环境要求不一致的情况”，在遗留代码复用、类库迁移等方面非常有用。
 * 2．适配器模式有对象适配器和类适配器两种形式的实现结构，但是类适配器采用“多继承”的实现方式，带来了不良的高耦合，所以一般不推荐使用。
 *  对象适配器采用“对象组合”的方式，更符合松耦合精神。
 */
public class CollectionData<T> extends ArrayList<T> {
    /**
     * @param gen 传入生成器实现类Government，生成器只负责返回下一个数据并计数
     * @param quantity 想要生成的值
     */
    public CollectionData(Generator<T> gen, int quantity){
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }
    public static <T>CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen,quantity);
    }
}
