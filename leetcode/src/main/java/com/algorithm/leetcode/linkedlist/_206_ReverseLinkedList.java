package com.algorithm.leetcode.linkedlist;

import com.algorithm.leetcode.ListNode;

/**
 * leetcode：https://leetcode.com/problems/reverse-linked-list/
 *
 * 反转链表
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月10日 19:00
 */
public class _206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
