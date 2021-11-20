package com.algorithm.common.datastructure.primitive;

import java.util.List;

/**
 * 单向链表
 *
 * @author bluefish 2018/7/16
 * @version 1.0.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        super();
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        super();
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode [value=" + val + "]";
    }

    public void printList() {
        ListNode p = this;
        while (p != null) {
            int value = p.val;
            p = p.next;
            if (p == null) {
                System.out.print(value + "");
            } else {
                System.out.print(value + " --> ");
            }
        }
        System.out.println();
    }

    public void circleListPrint() {
        ListNode head = new ListNode(0);
        head.next = this;
        ListNode p = this;
        while (p != null) {
            int value = p.val;
            p = p.next;
            if (p == head.next) {
                System.out.print(value + "");
                break;
            } else {
                System.out.print(value + " --> ");
            }
        }
        System.out.println();
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            int value = p.val;
            p = p.next;
            if (p == null) {
                System.out.print(value + "");
            } else {
                System.out.print(value + " --> ");
            }
        }
        System.out.println();
    }

    public static void printListInError(ListNode head) {
        ListNode p = head;
        while (p != null) {
            int value = p.val;
            p = p.next;
            if (p == null) {
                System.err.print(value + "");
            } else {
                System.err.print(value + " --> ");
            }
        }
        System.out.println();
    }

    /**
     * 将一个数组转换为链表
     *
     * @param array
     * @return
     */
    public static ListNode arrayToNode(int[] array) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int value : array) {
            p.next = new ListNode(value);
            p = p.next;
        }
        return head.next;
    }

    /**
     * 将一个集合转换为俩表
     *
     * @param array
     * @return
     */
    public static ListNode listToNode(List<Integer> array) {
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
