package com.algorithm.datastructure.linkedlist;

/**
 * 反转链表：
 *
 * @author bluefish 2019-06-24
 * @version 1.0.0
 */
public class ReverseNode {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToNode(array);
        ListNode.printList(head);
        head = reverseList(head);
        ListNode.printList(head);
    }

    public static ListNode reverseList(ListNode head){
        // 反转链表：1 --> 2 --> 3 --> 4 --> 5 --> 6
        // 第一步：反转  2 --> 3 --> 4 --> 5 --> 6，反转之后变成：6 --> 5 --> 4 --> 3 --> 2 <-- 1
        // 再将 2 和 1 的next改变下即可

        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 子链表
        ListNode newNode = reverseList(head.next);
        // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        ListNode node = head.next;
        // 让 2 的 next 指向 1
        node.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        return newNode;
    }
}
