package com.algorithm.interview.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月14日 16:44
 */
public class ClearValue {

    public ListNode clear_2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            if (cur.val == val) {
                pre.next = tmp;
                cur.next = null;
                cur = tmp;
            } else {
                pre = pre.next;
                cur = tmp;
            }
        }
        return dummy.next;
    }

    public ListNode clear_1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy.next;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}
