package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * leetcode:https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * 找到两个链表相交的点，保证链表是无环的
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月11日 13:41
 */
public class _160_IntersectionOfTwoLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 使用一个n变量，遍历第一个链表的时候 ++
        // 变量第二个链表的时候 -- 操作；
        // 比较n与0的，判断哪个链表长度更长；
        int n = 0;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA.next != null) {
            n++;
            curA = curA.next;
        }
        while (curB.next != null) {
            n--;
            curB = curB.next;
        }
        if (curA != curB) {
            return null;
        }
        // n 是 链表1长度减去链表2长度的值；
        curA = n > 0 ? headA : headB; // 哪个链表长，头变成curA
        curB = curA == headA ? headB : headA;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            curA = curA.next;
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
