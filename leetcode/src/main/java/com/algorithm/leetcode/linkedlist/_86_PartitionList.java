package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;
import com.algorithm.common.utils.ArrayUtils;

/**
 * leetcode: https://leetcode.com/problems/partition-list/
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月12日 11:21
 */
public class _86_PartitionList {

    public static void main(String[] args) {
//        int[] array = ArrayUtils.generateRandomArray(7, 1, 20);
        int[] array = {9, 12, 14, 13, 11, 6, 18};
        ArrayUtils.print(array, 10);
//        int val = array[5];
        int val = 12;
        System.err.println("val = " + val);
        ListNode head = ListNode.arrayToNode(array);
        ListNode.printList(head);
        ListNode res = partition(head, val);
        ListNode.printListInError(res);
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode lessStart = null;
        ListNode lessEnd = null;
        ListNode geStart = null;
        ListNode geEnd = null;

        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < x) {
                if (lessStart == null) {
                    lessStart = head;
                    lessEnd = head;
                } else {
                    lessEnd.next = head;
                    lessEnd = head;
                }
            } else {
                if (geStart == null) {
                    geStart = head;
                    geEnd = head;
                } else {
                    geEnd.next = head;
                    geEnd = head;
                }
            }
            head = next;
        }

        if (lessEnd != null) {
            lessEnd.next = geStart;
        }
        return lessStart != null ? lessStart : geStart;
    }
}
