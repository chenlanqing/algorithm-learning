package com.algorithm.datastructure.linkedlist;

/**
 * @author QingFan 2021/9/11
 * @version 1.0.0
 */
public class ReverseKGroupListFromEnd {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = ListNode.arrayToNode(array);
        ListNode.printList(head);
        ListNode result = new ReverseKGroupListFromEnd().solve(head, 3);
        ListNode.printList(result);
    }

    public ListNode solve(ListNode head, int k) {
        // 先反转一次
        head = reverseList(head);
        // 每K个反转
        head = reverseKGroup(head, k);
        // 再次反转链表
        head = reverseList(head);
        return head;
    }

    // k个为一组逆序
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        } //判断节点的数量是否能够凑成一组
        if (temp == null) {
            return head;
        }
        ListNode t2 = temp.next;
        temp.next = null;
        //把当前的组进行逆序
        ListNode newHead = reverseList(head);
        //把之后的节点进行分组逆序
        ListNode newTemp = reverseKGroup(t2, k);
        // 把两部分连接起来
        head.next = newTemp;
        return newHead;
    }

    // 逆序单链表
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
