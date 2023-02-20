package com.xijianlv.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xijianlv
 */
public class No146 {

    private final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    LRULinkedHashMap<Integer, Integer> cache = new LRULinkedHashMap<>();

    private static Integer capacity;

    public No146(Integer capacity) {
        No146.capacity = capacity;
    }

    public Integer get(Integer key) {
        try {
            readLock.lock();
            Integer value = cache.get(key);
            if (value == null) {
                return -1;
            }
            cache.remove(key);
            cache.put(key, value);
            return value;
        } catch (Exception e) {
            return -1;
        } finally {
            readLock.unlock();
        }
    }

    public void put(Integer key, Integer value) {
        try {
            writeLock.lock();
            if (cache.containsKey(key)) {
                cache.remove(key);
            }
            cache.put(key, value);
        } catch (Exception e) {

        } finally {
            writeLock.unlock();
        }
    }


    private static class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            if (size() > capacity) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        No146 lRUCache = new No146(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }

}
