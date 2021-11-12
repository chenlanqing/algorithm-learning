package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月10日 17:00
 */
public class _1290_ConvertBinaryToInt_2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(
                1,
                new ListNode(0,
                        new ListNode(
                                1,
                                new ListNode(0)
                        )
                )
        );
        System.out.println(getDecimalValue(head));
    }

    public static int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int ans = 0;
        while (head != null) {
            System.out.println(ans + " * 2 + " + head.val + " = " + ((ans << 1) + head.val));
            ans = (ans << 1) + head.val;
            head = head.next;
        }
        return ans;
    }
}
