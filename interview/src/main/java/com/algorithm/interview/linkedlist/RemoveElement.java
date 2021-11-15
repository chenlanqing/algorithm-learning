package com.algorithm.interview.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * 给定单链表、值val，删除所有值为val的节点
 * <p>
 * 样例输入：1 -> 6 -> 4 -> 6 -> 6 -> 3 -> 5，val = 6
 * <p>
 * 样例输出：1 -> 4 -> 3 -> 5
 * <br>
 * 思路:<p>
 * 删除，pre指针、p指针：<p>
 * 如果p的值等于val，删除；pre不动，p往后移动一位<p>
 * 否则，pre、p都往后移动一位
 * <p>
 * 边界情况：头结点head的值为val
 *
 * @author bluefish 2018/7/16
 * @version 1.0.0
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 4, 3, 5, 4};
        ListNode head = ListNode.arrayToNode(array);
        ListNode.printList(head);
        System.out.println("~~~~~~~");
        ListNode listNode = removeElements(head, 3);
        ListNode.printList(listNode);
    }

    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        } else {
            // 考虑到 head 节点被删除的情况
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode pre = newHead;
            ListNode p = head;
            while (p != null) {
                if (p.val == val) {
                    pre.next = p.next;
                    p = p.next;
                } else {
                    pre = p;
                    p = p.next;
                }
            }
            return newHead.next;
        }
    }
}
