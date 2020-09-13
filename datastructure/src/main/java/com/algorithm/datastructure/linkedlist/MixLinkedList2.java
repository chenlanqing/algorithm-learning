package com.algorithm.datastructure.linkedlist;

/**
 * @author QingFan 2020-09-13
 * @version 1.0.0
 */
public class MixLinkedList2 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.arrayToNode(array);

        ListNode.printList(listNode);

        reorderList(listNode);

        ListNode.printList(listNode);
    }

    public static int getLength(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        return count;
    }

    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode next = null;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        head.next = null;
        return pre;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int len = getLength(head);
        int half = len / 2;
        // 考虑奇数个问题
        if (len % 2 != 0) {
            half++;
        }
        ListNode leftEnd = head;
        for (int i = 1; i < half; i++) {
            leftEnd = leftEnd.next;
        }
        ListNode rightStart = leftEnd.next;
        rightStart = reverseListNode(rightStart);
        leftEnd.next = null;
        ListNode left = head;
        ListNode right = rightStart;
        boolean flag = true;
        ListNode next;
        while (right != null) {
            if (flag) {
                next = left.next;
                left.next = right;
                left = next;
            } else {
                next = right.next;
                right.next = left;
                right = next;
            }
            flag = !flag;
        }
    }
}
