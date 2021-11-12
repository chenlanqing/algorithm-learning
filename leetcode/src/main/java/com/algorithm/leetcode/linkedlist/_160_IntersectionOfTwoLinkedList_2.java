package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * leetcode:https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * 找到两个链表相交的点，可能存在链表有环的情况，是上面leetcode的变种
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月11日 14:20
 */
public class _160_IntersectionOfTwoLinkedList_2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 找出两个链表的环
        ListNode loopA = getLoopNode(headA);
        ListNode loopB = getLoopNode(headB);
        // 如果两个链表都没有环
        if (loopA == null && loopB == null) {
            return noLoop(headA, headB);
        }
        // 代表两个链表都有环
        if (loopA != null && loopB != null) {
            return bothLoop(headA, loopA, headB, loopB);
        }
        return null;
    }

    private ListNode bothLoop(ListNode headA, ListNode loopA, ListNode headB, ListNode loopB) {
        // 两个链表的环节点相同，即是共用环
        if (loopA == loopB) {
            int n = 0;
            ListNode curA = headA;
            ListNode curB = headB;

            while (curA.next != loopA) {
                n++;
                curA = curA.next;
            }
            while (curB.next != loopB) {
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
        } else {
            ListNode curA = loopA.next;
            // curA 返回 loopA之前，遇到 loopB，则是相交点，loopA 和 loopB都可以；
            while (curA != loopA) {
                if (curA == loopB) {
                    return loopA;
                }
                curA = curA.next;
            }
            // 最终就是两个独立的链表环
            return null;
        }
    }

    private ListNode getLoopNode(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = root;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private ListNode noLoop(ListNode headA, ListNode headB) {
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
