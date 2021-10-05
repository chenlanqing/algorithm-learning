package com.algorithm.datastructure.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * 删除倒数第N个节点：https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author QingFan 2021/9/5
 * @version 1.0.0
 */
public class RemoveNThNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy, right = dummy;
        for (int i = 0; i < n; i++) {
            if (right == null) {
                return dummy.next;
            }
            right = right.next;
        }

        while (right != null && right.next != null) {
            left = left.next;
            right = right.next;
        }

        if (left.next != null) {
            left.next = left.next.next;
        }

        return dummy.next;
    }
}
