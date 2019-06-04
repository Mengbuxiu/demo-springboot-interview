package com.java_concurrent._2._3;

/**
 * @author Alin
 * @version 1.0
 * @description // volatile 保证可见性
 * @date 2019/6/4 19:38
 *
 * 当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
 * 　　而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，什么时候被写入主存是不确定的，
 * 当其他线程去读取时，此时内存中可能还是原来的旧值，因此无法保证可见性。
 * 　　另外，通过synchronized和Lock也能够保证可见性，synchronized和Lock能保证同一时刻只有一个线程获取锁然后执行同步代码，
 * 并且在释放锁之前会将对变量的修改刷新到主存当中。因此可以保证可见性。
 *
 * 一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
 *
 * 　　1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
 *
 * 　　2）禁止进行指令重排序。
 *
 * happen-before原则(先行发生原则)
 *
 *     volatile变量规则：对一个变量的写操作先行发生于后面对这个变量的读操作
 *
 *
 * https://www.cnblogs.com/dolphin0520/p/3920373.html
 * 指令重排？看语句之间是否有依赖性？
 */
public class NoVisibility {
    private volatile static boolean ready;// java -version 查看 jvm是Server模式，不加volatile程序永远不会退出
    private static int number;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!ready) ;
            System.out.println(number);
        });
        thread.start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(10000);
    }
}
