package com.algorithm.datastructure.linkedlist;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln，
 * <p>
 * 将其重新排列后变为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * @author QingFan 2020-09-13
 * @version 1.0.0
 */
public class MixLinkedList {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.arrayToNode(array);

        ListNode.printList(listNode);

        reorderList(listNode);

        ListNode.printList(listNode);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 步骤 1: 通过快慢指针找到链表中点
        // 通过调节快慢指针的起始位置，可以保证前半部分的长度大于等于后半部分
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 步骤 2: 反转后半部分的链表
        // 在反转之前需要的一个操作是将前后半部分断开
        ListNode second = slow.next;
        slow.next = null;
        second = reverseList(second);

        // 步骤 3: 合并前半部分链表以及反转后的后半部分链表
        mergeList(head, second);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, tmp = null, pointer = head;
        while (pointer != null) {
            tmp = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = tmp;
        }

        return prev;
    }

    private static void mergeList(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;

        while (first != null && second != null) {
            pointer.next = first;
            first = first.next;
            pointer.next.next = second;
            second = second.next;
            pointer = pointer.next.next;
        }

        // 因为我们之前找中点的时候保证了前半部分的长度不小于后半部分的长度
        // 因此交叉后，多出来的部分只可能是前半部分，判断前半部分即可
        if (first != null) {
            pointer.next = first;
        }
    }
}
