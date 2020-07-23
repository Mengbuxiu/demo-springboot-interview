package com.jeek_time.java并发编程实战.读写锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 按需加载
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("unchecked")
class Cache2<K, V> {
    final Map<K, V> cache =
            new HashMap<>();
    final ReadWriteLock rwl =
            new ReentrantReadWriteLock();
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    V get(K key) {
        V v = null;
        //读缓存
        r.lock();
        try {
            v = cache.get(key);
        } finally {
            r.unlock();
        }
        //缓存中存在，返回
        if (v != null) {
            return v;
        }
        //缓存中不存在，查询数据库
        w.lock();
        try {
            /* 再次验证 */
            //其他线程可能已经查询过数据库
            v = cache.computeIfAbsent(key, k -> (V) "value");
            //查询数据库 v=...
        } finally {
            w.unlock();
        }
        return v;
    }
}