package com.algorithm.interview.lru;

import java.util.*;

/**
 * @author bluefish 2018/11/7
 * @version 1.0.0
 */
public class LRULinkedMap<K, V> {


    /**
     * 最大缓存大小
     */
    private int cacheSize;

    private LinkedHashMap<K, V> cacheMap;


    public LRULinkedMap(int cacheSize) {
        this.cacheSize = cacheSize;

        cacheMap = new LinkedHashMap(16, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if (cacheSize + 1 == cacheMap.size()) {
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

    public void put(K key, V value) {
        cacheMap.put(key, value);
    }

    public V get(K key) {
        return cacheMap.get(key);
    }


    public Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<Map.Entry<K, V>>(cacheMap.entrySet());
    }

    @Override
    public String toString() {
       return cacheMap.toString();
    }
}