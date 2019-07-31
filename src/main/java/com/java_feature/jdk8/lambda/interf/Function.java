package com.java_feature.jdk8.lambda.interf;

import java.util.Objects;

/**
 * 表示一个函数，接收一个参数，返回一个结果
 * Represents a function that accepts one argument and produces a result.
 *
 * 这个函数接口的功能方法是apply
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object)}.
 *
 *
 *        <T> 输入到函数的类型
 * @param <T> the type of the input to the function
 *        <R> 函数结果的类型
 * @param <R> the type of the result of the function
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Function<T, R> {

    /**
     * 应用给这个函数的参数
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);

    /**
     * 返回一个组合函数，该函数首先将before函数应用于其输入，然后将此函数应用于结果。
     * 如果对任一函数的求值抛出异常，则将其转发给组合函数的调用者。
     *
     * Returns a composed function that first applies the {@code before}
     * function to its input, and then applies this function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     *        <V> before函数和组合函数的输入类型
     * @param <V> the type of input to the {@code before} function, and to the composed function
     *
     *        before 在做这个行为之前先做的行为，比如吃饭之前先喝口水
     * @param before the function to apply before this function is applied
     *
     *         一个组合函数，首先应用before函数，然后应用此函数
     * @return a composed function that first applies the {@code before} function and then applies this function
     *
     * @throws NullPointerException if before is null
     *
     * @see #andThen(Function)
     */
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);

        return (V v) -> {
            //先对传入的行为function进行表现，把表现的结果再和调用compose的对象进行组合

            T res = before.apply(v);
            R apply = this.apply(res);

            return apply;
        };
    }

    /**
     * 返回首先将此函数应用于其输入的组合函数，然后将after函数应用于结果。
     * 如果对任一函数的求值抛出异常，则将其转发给组合函数的调用者。
     *
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the type of output of the {@code after} function, and of the
     *           composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     *
     * @see #compose(Function)
     */
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);

        return (T t) -> {
            R res = this.apply(t);
            //andThen是先对传入的参数调this.apply方法,拿到结果res后再表现传入的function的行为，和compose刚好相反
            return after.apply(res);
        };
    }

    /**
     * 总是返回这个函数的输入参数值
     * Returns a function that always returns its input argument.
     *
     * @param <T> the type of the input and output objects to the function
     * @return a function that always returns its input argument
     */
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}