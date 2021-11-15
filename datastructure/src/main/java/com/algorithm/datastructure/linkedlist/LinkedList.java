package com.algorithm.datastructure.linkedlist;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月14日 12:27
 */
public class LinkedList<E> {

    private class ListNode {

        public E val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(E e) {
            val = e;
        }

        public ListNode(E e, ListNode next) {
            val = e;
            this.next = next;
        }
    }

    private ListNode dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new ListNode();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        ListNode pre = dummyHead;
        int i = 0;
        while (i < index) {
            pre = pre.next;
            i++;
        }
        ListNode cur = new ListNode(e);
        cur.next = pre.next;
        pre.next = cur;
        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(e, 0);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(e, size);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        ListNode pre = dummyHead.next;
        int i = 0;
        while (i < index) {
            i++;
            pre = pre.next;
        }
        return pre.val;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        ListNode pre = dummyHead.next;
        int i = 0;
        while (i < index) {
            i++;
            pre = pre.next;
        }
        pre.val = e;
    }

    public boolean contains(E e) {
        ListNode pre = dummyHead.next;
        while (pre != null) {
            if (pre.val.equals(e)) {
                return true;
            }
            pre = pre.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        ListNode pre = dummyHead;
        int i = 0;
        while (i < index) {
            pre = pre.next;
            i++;
        }
        ListNode res = pre.next;
        pre.next = res.next;
        res.next = null;
        size--;
        return res.val;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(E e) {
        ListNode pre = dummyHead.next;
        // 遍历链表，找出需要删除的前一个数据
        while (pre.next != null) {
            if (pre.next.val.equals(e)) {
                break;
            }
            pre = pre.next;
        }
        ListNode cur = dummyHead.next;
        while (pre.next != null) {
            ListNode delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        ListNode cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
