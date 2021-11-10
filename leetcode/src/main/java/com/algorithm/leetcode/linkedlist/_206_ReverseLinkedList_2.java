package com.algorithm.leetcode.linkedlist;

import com.algorithm.leetcode.ListNode;

/**
 * 使用递归反转链表
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月10日 19:06
 */
public class _206_ReverseLinkedList_2 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseList(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return newNode;
    }
}
