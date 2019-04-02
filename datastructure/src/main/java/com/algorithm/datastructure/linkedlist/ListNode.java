package com.algorithm.datastructure.linkedlist;

/**
 * @author bluefish 2018/7/16
 * @version 1.0.0
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int val) {
        super();
        this.value = val;
    }

    public ListNode(int val, ListNode next) {
        super();
        this.value = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode [value=" + value + "]";
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static ListNode arrayToList(int[] array) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int value : array) {
            p.next = new ListNode(value);
            p = p.next;
        }
        return head.next;
    }

    /**
     * 创建约瑟夫环
     */
    public static ListNode arrayToCircle(int[] array) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int value : array) {
            p.next = new ListNode(value);
            p = p.next;
        }
        p.next = head.next;
        return head.next;
    }
}
