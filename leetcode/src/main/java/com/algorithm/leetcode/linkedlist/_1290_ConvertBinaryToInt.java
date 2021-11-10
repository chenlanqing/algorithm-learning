package com.algorithm.leetcode.linkedlist;

import com.algorithm.leetcode.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * leetcode: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * 一个链表中的元素只有1和0，高位在前，其存储的是一个二进制数，将其转换为十进制
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月10日 16:47
 */
public class _1290_ConvertBinaryToInt {

    /**
     * 最简单的办法：逆序获取链表的数据，然后按照二进制转10进制的运算规则转换
     */
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        recursive(head, list);

        int sum = 0, len = list.size();
        for (int i = 0; i < len; i++) {
            int t = list.get(i);
            sum += t * (int) Math.pow(2, i);
        }
        return sum;
    }

    private void recursive(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        recursive(head.next, list);
        list.add(head.val);
    }
}
