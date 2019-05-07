package com.thinkinjava.basic._14_7;

/**
 * 这篇文章讲的很好
 * http://www.cnblogs.com/silverLee/archive/2010/02/05/1664577.html
 * 1.用插入的对象来代替实际的对象，代理通常充当中间人的角色
 * 2.何时用代理？ 将额外的操作从实际的对象中分离到不同的地方，使用简单的
 * 操作以做出适合实际应用的修改
 * https://blog.csdn.net/briblue/article/details/73928350
 *  看代理模式.png
 *  需要注意的有下面几点：
 *
 * 用户只关心接口功能，而不在乎谁提供了功能。上图中接口是 Subject。
 * 接口真正实现者是上图的 RealSubject，但是它不与用户直接接触，而是通过代理。
 * 代理就是上图中的 Proxy，由于它实现了 Subject 接口，所以它能够直接与用户接触。
 * 用户调用 Proxy 的时候，Proxy 内部调用了 RealSubject。所以，Proxy 是中介者，它可以增强 RealSubject 操作。
 *
 * */