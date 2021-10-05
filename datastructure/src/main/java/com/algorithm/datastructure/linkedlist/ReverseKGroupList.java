package com.algorithm.datastructure.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * @author QingFan 2021/9/11
 * @version 1.0.0
 */
public class ReverseKGroupList {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpy = new ListNode(-1, head);
        ListNode cur = head;
        ListNode pre = dumpy;
        while (cur != null) {
            ListNode tail = cur;
            int index = 0;
            while (index < k && cur != null) {
                cur = cur.next;
                index++;
            }
            if (index != k) {
                pre.next = tail;
            } else {
                pre.next = reverse(tail, k);
                pre = tail;
            }
        }
        return dumpy.next;
    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        int n = k;
        while (cur != null && n-- > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
