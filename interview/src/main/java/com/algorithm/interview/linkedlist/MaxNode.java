package com.algorithm.interview.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * 链表的最大元素
 *
 * @author QingFan 2020-08-14
 * @version 1.0.0
 */
public class MaxNode {

    public static void main(String[] args) {
        int[] array = {19, 12, 32, 43, 15, 6};
        ListNode head = ListNode.arrayToNode(array);

        int value = findMax(head);

        System.out.println(value);
    }

    private static int findMax(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode p = head.next;
        int max = p.val;
        p = p.next;
        while (p != null) {
            if (max < p.val) {
                max = p.val;
            }
            p = p.next;
        }
        return max;
    }


}
