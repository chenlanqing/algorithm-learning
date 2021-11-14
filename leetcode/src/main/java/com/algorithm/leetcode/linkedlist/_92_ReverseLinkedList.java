package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月13日 09:40
 */
public class _92_ReverseLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.arrayToNode(arr);
        reverseBetween(head, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left > right) {
            return null;
        }
        ListNode dumpy = new ListNode();
        dumpy.next = head;
        int k = 1;
        // 遍历，直达k<n，其中 first 为 需要反转节点的前一个节点
        ListNode first = dumpy;
        while (k < left) {
            first = first.next;
            k++;
        }
        // 需要记录到反转节点的起始节点，然后是最后一个节点的next节点位置
        ListNode pre = first.next;
        ListNode l = pre.next;
        ListNode next = null;
        final ListNode top = pre;
        while (k < right) {
            next = l.next;
            l.next = pre;
            pre = l;
            l = next;
            k++;
        }
        top.next = l;
        first.next = pre;
        return dumpy.next;
    }
}
