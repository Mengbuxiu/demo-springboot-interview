package com.thinkinjava.basic._15_3.coffee;

import com.thinkinjava.basic._15_3.interf.Generator;

import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Alin
 * @version 1.0
 * @description // 随机产生各种咖啡
 * @date 2019/5/5 14:11
 * Generator<Coffee> 是咖啡生成器接口
 * Iterable<Coffee> 是为了方便调用foreach，详情查看javadoc
 */
public class CoffeeGenerator implements Generator<Coffee>,
        Iterable<Coffee> {

    private Class[] types = {
            Latte.class, Mocha.class,
            Cappuccino.class, Americano.class,
            Breve.class
    };
    private static Random random = new Random();

    private CoffeeGenerator() {
    }

    private int size = 0;

    private CoffeeGenerator(int sz) {
        size = sz;
    }

    /**
     * The call
     *
     * <pre>{@code
     *  clazz.newInstance()
     *  }</pre>
     * <p>
     * can be replaced by
     *
     * <pre>{@code
     *  clazz.getDeclaredConstructor().newInstance()
     *  }</pre>
     *
     * @return 公共父类
     */
    @SuppressWarnings("unchecked")
    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    @NotNull
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    /**
     * 私有内部计数器
     */
    private class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 2; i++) {
            System.out.println(gen.next());
        }
        for (Coffee c : new CoffeeGenerator(2)) {
            System.out.println(c);
        }
    }
}
