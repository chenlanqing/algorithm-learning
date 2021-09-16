package com.algorithm.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QingFan 2021/9/12
 * @version 1.0.0
 */
public class DoubleLinkedListLRU {

    static class LruNode {

        String key;
        Object value;
        LruNode next;
        LruNode pre;

        public LruNode(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<String, LruNode> map = new HashMap<>();
    LruNode head;
    LruNode tail;
    int capacity;

    public DoubleLinkedListLRU(int capacity) {
        this.capacity = capacity;
    }

    public void put(String key, Object value) {
        if (head == null) {
            head = new LruNode(key, value);
            tail = head;
            map.put(key, head);
        }
        LruNode node = map.get(key);
        if (node != null) {
            node.value = value;
            removeAndInsert(node);
        } else {
            LruNode tmp = new LruNode(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                tail = tail.pre;
                tail.next = null;
            }
            map.put(key, tmp);
            tmp.next = head;
            head.pre = tmp;
            head = tmp;
        }
    }

    public Object get(String key) {
        LruNode node = map.get(key);
        if (node == null) {
            return null;
        }
        removeAndInsert(node);
        return node.value;
    }

    private void removeAndInsert(LruNode node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            tail = node.pre;
            tail.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.next = head;
        node.pre = null;
        head.pre = node;
        head = node;
    }
}
