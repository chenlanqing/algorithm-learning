package com.algorithm.datastructure.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * leetCode：https://leetcode.com/problems/middle-of-the-linked-list
 *
 * @author QingFan 2021/9/13
 * @version 1.0.0
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToNode(array);
        ListNode.printList(head);
        middleNode(head).printList();
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 初始化快慢指针，让其在一开始时都指向链表头节点
        ListNode slow = head, fast = head;
        // 判断快指针是不是到了链表结尾
        // 因为快指针一次走两步，所以这里要先判断其是不是为空
        while (fast != null && fast.next != null) {
            // 慢指针每走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 最后慢指针指向的节点就是链表的中点
        return slow;
    }
}
