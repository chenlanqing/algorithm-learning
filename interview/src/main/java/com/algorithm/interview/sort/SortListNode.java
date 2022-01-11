package com.algorithm.interview.sort;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * 链表排序
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月09日 09:55
 */
public class SortListNode {

    public static void main(String[] args) {
        int[] arr1 = {-1, 5, 3, 4, 0};
        int[] arr2 = {4, 2, 1, 3};
        final ListNode node1 = ListNode.arrayToNode(arr1);
        final ListNode node2 = ListNode.arrayToNode(arr2);
        ListNode.printList(sortList(node1));
        ListNode.printList(sortList(node2));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (left != null && right != null) {
            if (left.val > right.val) {
                temp.next = right;
                right = right.next;
            } else {
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }
        return head.next;
    }
}
