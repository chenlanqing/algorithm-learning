package com.algorithm.datastructure.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * 合并有序链表
 *
 * LeetCode：https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author QingFan 2021/9/5
 * @version 1.0.0
 */
public class MergeSortList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        // 创建 dummy 节点
        ListNode dummy = new ListNode(0);
        // 用户构建合并链表的指针
        ListNode pointer = dummy;

        while (l1 != null && l2 != null) {
            // 比较两个链表的当前最小节点
            // 如果 l2 更小，把 l2 的当前节点放到合并链表的末尾，并移动指针到下一个节点
            if (l1.val > l2.val) {
                pointer.next = l2;
                l2 = l2.next;
            } else {
                // 如果 l1 更小，把 l1 的当前节点放到合并链表的末尾，并移动指针到下一个节点
                pointer.next = l1;
                l1 = l1.next;
            }
            // 移动指针到合并链表末尾，因为每次都有且仅有一个节点被加到合并链表，这里 .next 即可
            pointer = pointer.next;
        }
        // 把没拆分完的那个链表整个直接接到合并的链表后面
        if (l1 != null) {
            pointer.next = l1;
        } else {
            pointer.next = l2;
        }

        return dummy.next;
    }
}
