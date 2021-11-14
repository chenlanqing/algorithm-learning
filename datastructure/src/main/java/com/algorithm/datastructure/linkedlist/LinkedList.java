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

    private ListNode head;
    private int size;

    public LinkedList() {
        head = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {

    }

}
