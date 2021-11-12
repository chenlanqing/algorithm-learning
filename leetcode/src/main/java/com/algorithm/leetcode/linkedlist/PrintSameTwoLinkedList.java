package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;
import com.algorithm.common.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 *
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 *
 * 测试样例：{1,2,3,4,5,6,7},{2,4,6,8,10}
 *
 * 返回：[2.4.6]
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月11日 09:30
 */
public class PrintSameTwoLinkedList {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {2, 4, 6, 8, 10};
        ListNode headA = ListNode.arrayToNode(arr1);
        ListNode headB = ListNode.arrayToNode(arr2);

        ArrayUtils.print(findCommonParts(headA, headB), 10);
    }

    public static int[] findCommonParts(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        List<Integer> res = new ArrayList<>();

        while (a != null && b != null) {
            if (a.val > b.val) {
                b = b.next;
            } else if (a.val < b.val) {
                a = a.next;
            } else {
                res.add(a.val);
                a = a.next;
                b = b.next;
            }
        }
        if (res.size() == 0) {
            return null;
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
