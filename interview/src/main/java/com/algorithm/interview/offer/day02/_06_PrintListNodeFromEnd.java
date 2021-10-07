package com.algorithm.interview.offer.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QingFan 2021/10/6
 * @version 1.0.0
 */
public class _06_PrintListNodeFromEnd {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        reverse(head, res);
        int size = res.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public void reverse(ListNode head, List<Integer> res) {
        if (head == null) {
            return;
        }
        reverse(head.next, res);
        res.add(head.val);
    }

    private class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
