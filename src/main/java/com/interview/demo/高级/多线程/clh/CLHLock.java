package com.interview.demo.高级.多线程.clh;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 一种锁思路实现，smp架构中使用
 */
public class CLHLock implements Lock {
    AtomicReference<QNode> tail ;
    ThreadLocal<QNode> myPred;  
    ThreadLocal<QNode> myNode;  
  
    public CLHLock() {  
        tail = new AtomicReference<>(new QNode());
        myNode = ThreadLocal.withInitial(QNode::new);
        myPred = ThreadLocal.withInitial(() -> null);
    }  
  
    @Override  
    public void lock() {  
        QNode qnode = myNode.get();  
        qnode.locked = true;  
        QNode pred = tail.getAndSet(qnode);  
        myPred.set(pred);  
        while (pred.locked) {}
    }

    @Override
    public void lockInterruptibly() {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) {
        return false;
    }

    @Override  
    public void unlock() {  
        QNode qnode = myNode.get();  
        qnode.locked = false;  
        myNode.set(myPred.get());  
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    static class QNode {
        boolean locked = false;
        QNode next = null;
    }
}