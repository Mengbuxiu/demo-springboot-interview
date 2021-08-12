package com.didi.线程死亡finally是否会执行;

import com.java.book.concurrent._3._1._1.ReenterLock;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhenglin
 * @desc
 * @date 2021/8/9 4:19 下午
 */
public class TestThreadDeadForFinallyDo {
    private static ReentrantLock reenterLock = new ReentrantLock();

    public static void main(String[] args) {
        boolean flag = false;
        try {
            flag = reenterLock.tryLock();
            System.out.println("lock");
            Thread.currentThread().stop();
//            System.out.println(1/0);
            throw new HttpPostRequestDecoder.ErrorDataDecoderException();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                reenterLock.unlock();
                System.out.println("unlock");
            }

        }
    }
}
