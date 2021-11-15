package com.algorithm.interview.linkedlist;

/**
 * @author QingFan 2021/9/12
 * @version 1.0.0
 */
public class LinkedListLRU {

    static class LruNode {
        String key;
        Object value;
        LruNode next;
        public LruNode(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    LruNode head;
    int size = 0;
    int capacity = 0;

    public LinkedListLRU(int capacity) {
        this.capacity = capacity;
    }

    public Object get(String key) {
        LruNode cur = head;
        LruNode pre = head;
        if (head == null) {
            return null;
        }
        if (cur.key.equals(key)) {
            return cur.value;
        }
        cur = cur.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        // 代表没找到了节点
        if (cur == null) {
            return null;
        }
        // 进行删除
        pre.next = cur.next;
        // 删除之后插入头结点
        cur.next = head;
        head = cur;
        return cur.value;
    }

    public void put(String key, Object value) {
        if (capacity == 1) {
            head = new LruNode(key, value);
        }
        LruNode cur = head;
        LruNode pre = head;
        if (head == null) {
            head = new LruNode(key, value);
            head.next = null;
            return;
        }
        // 判断是否为第一个
        if (head.key.equals(key)) {
            head.value = value;
            return;
        }
        cur = cur.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        // 代表要插入的节点的 key 已存在，则进行 value 的更新
        // 以及把它放到第一个节点去
        if (cur != null) {
            cur.value = value;
            pre.next = cur.next;
            cur.next = head;
            head = cur;
        } else {
            // 创建一个临时节点
            LruNode tmp = new LruNode(key, value);
            if (size >= capacity) {
                cur = head;
                // 往后平移一个节点
                while (cur.next != null && cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
                tmp.next = head;
                head = tmp;
            }
        }
    }
}
