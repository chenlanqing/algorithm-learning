package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;
import java.util.Stack;

/**
 * 回文链表
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月11日 09:41
 */
public class _234_PalindromeLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};
        ListNode root = ListNode.arrayToNode(arr);
        ListNode.printList(root);
        System.out.println(isPalindrome(root));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {// 找到中间的节点
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next; // fast 为右边部分的第一个节点
        slow.next = null; // 中间节点的指向null；
        ListNode node = null;
        while (fast != null) {
            node = fast.next;
            fast.next = slow;
            slow = fast;
            fast = node;
        }
        node = slow;
        fast = head;
        boolean res = true;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        slow = node.next;
        node.next = null;
        while (slow != null) {
            fast = slow.next;
            slow.next = node;
            node = slow;
            slow = fast;
        }
        return res;
    }

    private boolean isPalindromeByStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (p.val != stack.pop()) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
