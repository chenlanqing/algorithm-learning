package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;
import com.algorithm.common.utils.ArrayUtils;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * <p>
 * 给到一个单链表的头结点，节点的值类型是整型，在给到一个整数 val，实现一个调整链表的函数， 将链表调整为左部分都是值小于val的节点，中间部分都是值等于 val的节点，有部分都是值大于val的节点；
 * </p>
 * 空间复杂度要求 O(1)
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月11日 09:53
 */
public class PartitionLinkedList {

    public static void main(String[] args) {
//        int[] array = ArrayUtils.generateRandomArray(7, 1, 20);
        int[] array = {9, 12, 14, 13, 11, 6, 18};
        ArrayUtils.print(array, 10);
        int val = array[5];
        System.err.println("val = " + val);
        ListNode head = ListNode.arrayToNode(array);
        ListNode.printList(head);
        ListNode res = partitionList(head, val);
        ListNode.printListInError(res);
    }

    /**
     * 使用6个变量： 小于val的头、尾节点； 等于val的头、尾节点； 大于val的头、尾节点； 最后将这小于val的尾节点连接等于val的头节点、将等于val的尾节点连接大于val的头结点
     */
    public static ListNode partitionList(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode lowStart = null;
        ListNode lowEnd = null;
        ListNode eStart = null;
        ListNode eEnd = null;
        ListNode highStart = null;
        ListNode highEnd = null;

        ListNode node;
        while (head != null) {
            node = head.next;
            head.next = null;
            if (head.val < val) {
                if (lowStart == null) {
                    lowStart = head;
                    lowEnd = head;
                } else {
                    lowEnd.next = head;
                    lowEnd = head;
                }
            } else if (head.val > val) {
                if (highStart == null) {
                    highStart = head;
                    highEnd = head;
                } else {
                    highEnd.next = head;
                    highEnd = head;
                }
            } else {
                if (eStart == null) {
                    eStart = head;
                    eEnd = head;
                } else {
                    eEnd.next = head;
                    eEnd = head;
                }
            }
            head = node;
        }

        if (lowEnd != null) {
            lowEnd.next = eStart;
            eEnd = eEnd == null ? lowEnd : eEnd;
        }

        if (eEnd != null) {
            eEnd.next = highStart;
        }
        return lowStart != null ? lowStart : (eStart != null ? eStart : highStart);
    }

}
