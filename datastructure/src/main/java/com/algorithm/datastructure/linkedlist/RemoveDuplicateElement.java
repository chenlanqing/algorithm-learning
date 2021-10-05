package com.algorithm.datastructure.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * 删除链表中的重复元素
 * <p>
 * 给出一个有序链表，删除其中所有重复元素，使得每个元素只保留一次
 * <p>
 * 如 1 -> 1 -> 2，返回 1 -> 2
 * <p>
 * 如 1 -> 1 -> 2 -> 3 -> 3，返回 1 -> 2 -> 3
 *
 * @author bluefish 2018/7/16
 * @version 1.0.0
 */
public class RemoveDuplicateElement {

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        ListNode head = ListNode.arrayToNode(array);
        ListNode.printList(head);

//        ListNode.printList(removeDuplicateNode(head));


        ListNode.printList(deleteDuplicates(head));
    }

    private static ListNode removeDuplicateNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode pre = head;
            ListNode p = head.next;
            while (p != null) {
                if (pre.val == p.val) {
                    while (p != null && pre.val == p.val) {
                        p = p.next;
                    }
                    pre.next = p;
                } else {
                    pre = p;
                    p = p.next;
                }
            }
            return head;
        }
    }

}
