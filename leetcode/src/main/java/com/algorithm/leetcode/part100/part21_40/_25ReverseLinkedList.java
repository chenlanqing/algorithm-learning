package com.algorithm.leetcode.part100.part21_40;

import com.algorithm.datastructure.linkedlist.ListNode;

/**
 * leetcode 25:
 *
 * @author QingFan 2020-10-30
 * @version 1.0.0
 */
public class _25ReverseLinkedList {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode node = ListNode.arrayToNode(array);
        ListNode.printList(node);

        ListNode group = reverseKGroup(node, 2);
        ListNode.printList(group);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpy = new ListNode(-1, head);
        ListNode cur = head;
        ListNode pre = dumpy;
        while (cur != null) {
            ListNode tail = cur;
            int index = 0;
            while (index < k && cur != null) {
                cur = cur.next;
                index ++;
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
