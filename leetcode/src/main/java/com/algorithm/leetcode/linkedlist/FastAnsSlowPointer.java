package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * 快慢指针问题
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月12日 08:39
 */
public class FastAnsSlowPointer {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {1, 2, 3, 4, 5};

        ListNode head1 = ListNode.arrayToNode(arr1);
        ListNode head2 = ListNode.arrayToNode(arr2);

        findMid(head1);
        findMid(head2);
        System.out.println("~~~~~~~~~~~~~~");
        findMid_1(head1);
        findMid_1(head2);
    }

    public static void findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        assert slow != null;
        System.out.println(slow.val);
    }

    public static void findMid_1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        assert slow != null;
        System.out.println(slow.val);
    }
}
