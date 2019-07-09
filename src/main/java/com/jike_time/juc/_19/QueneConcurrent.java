package com.jike_time.juc._19;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alin
 * @version 1.0
 * @description // 如何让多线程步调一致？
 * @date 2019/7/9 15:23
 */
@Slf4j
public class QueneConcurrent {

    /**
     * 模拟订单队列
     */
    private Vector<Goods> pos = new Vector<>(100000);
    /**
     * 派送单队列
     */
    private Vector<Goods> dos = new Vector<>(100000);
    /**
     * 单线程
     */
    private ExecutorService executor = Executors.newFixedThreadPool(1);
    /**
     * 计数器
     */
    public final CyclicBarrier barrier = new CyclicBarrier(2, ()-> executor.submit(this::check));

    public final List<Goods> goods = new Vector<>(50000);
    /**
     * 检查
     */
    public void check(){
        log.info("开始执行差错检查-------------------------");
        Goods p = this.pos.remove(0);
        Goods d = this.dos.remove(0);
        if (!p.getGoodsName().equals(d.getGoodsName())) {
            goods.add(p);
        }
    }


    /**
     * 模拟产生数据
     */
    boolean produceData() {
        AtomicInteger i = new AtomicInteger(100000);
        Thread t1 = new Thread(() -> {
            while (i.getAndDecrement() > 0) {
                String goodsName = new Random().nextInt(10) + "";
                log.info("订单中添加商品>>>>>>>>：{}", goodsName);
                this.pos.add(new Goods(goodsName));
                try {
                    this.barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        AtomicInteger j = new AtomicInteger(100000);
        Thread t2 = new Thread(() -> {
            while (j.getAndDecrement() > 0) {
                String goodsName = new Random().nextInt(10) + "";
                log.info("派送单中添加商品 <<<<<<<<<<<<<：{}", goodsName);
                this.dos.add(new Goods(goodsName));
                try {
                    this.barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

}
