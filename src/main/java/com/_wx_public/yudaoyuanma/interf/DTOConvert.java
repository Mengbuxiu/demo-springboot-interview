package com._wx_public.yudaoyuanma.interf;

/**
 * 当实际工作中，完成了几个 API 的 DTO 转化时，我们会发现，这样的操作有很多很多，
 * 那么应该定义好一个接口，让所有这样的操作都有规则的进行。
 * 如果接口被定义以后，那么 convertFor 这个方法的语义将产生变化，它将是一个实现类。
 * @param <S> source 要转化的对象
 * @param <T> target 转化后的对象
 * 如果你是一个优秀的 Java 程序员，请为你想做的抽象接口，做好泛型吧。
 */
public interface DTOConvert<S,T> {
    /**
     * 两个对象中的属性名称和类型必须要一一对应
     * @param s 要转化的对象
     * @return 转化后的对象
     */
    T convert(S s);
}