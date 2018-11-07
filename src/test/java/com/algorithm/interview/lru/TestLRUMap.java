package com.algorithm.interview.lru;

import com.interview.lru.LRULinkedMap;
import com.interview.lru.LRUMap;
import org.junit.Test;

public class TestLRUMap {

    @Test
    public void put() throws Exception {
        LRUMap<String, Integer> lru = new LRUMap<>(3);
        lru.put("1", 1);
        lru.put("2", 2);
        lru.put("3", 3);
        System.out.println(lru.toString());

        lru.put("4", 4);
        System.out.println(lru.toString());

        lru.put("5", 5);
        System.out.println(lru.toString());
    }

    @Test
    public void get() throws Exception {
        LRUMap<String, Integer> lru = new LRUMap<>(3);
        lru.put("1", 1);
        lru.put("2", 2);
        lru.put("3", 3);
        System.out.println(lru.toString());

        Integer integer = lru.get("1");
        System.out.println(integer);
        System.out.println(lru.toString());
    }

    @Test
    public void testLinkedHashMap() throws Exception {
        LRULinkedMap<String, Integer> lru = new LRULinkedMap<>(3);
        lru.put("1", 1);
        lru.put("2", 2);
        lru.put("3", 3);
        System.out.println(lru);

        Integer integer = lru.get("1");
        System.out.println(integer);
        System.out.println(lru);
    }
}
