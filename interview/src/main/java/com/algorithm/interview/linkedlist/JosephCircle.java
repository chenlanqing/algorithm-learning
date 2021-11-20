package com.algorithm.interview.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;

/**
 * 约瑟夫环
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月19日 09:50
 */
public class JosephCircle {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode node = ListNode.arrayToCircle(arr);
        node.circleListPrint();
        new JosephCircle().josephusCircle(node, 5, 1, 2);
        node.circleListPrint();
    }

    /**
     * 取得一开始报数的人
     *
     * @param head 链表
     * @param start 开始报数的序号
     */
    public ListNode getStart(ListNode head, int start) {
        ListNode p = head;
        for (int i = 1; i < start; i++) {
            p = p.next;
        }
        return p;
    }

    /**
     * 单次的报数和删除节点
     *
     * @param node 报数的节点
     * @param step 步数
     */
    public ListNode countAndRemove(ListNode node, int step) {
        ListNode pre = node;
        for (int i = 1; i < step - 1; i++) {
            pre = pre.next;
        }
        System.out.print(pre.next.val + "\t");
        pre.next = pre.next.next;
        return pre.next;
    }

    /**
     * @param head 头节点
     * @param n 一共多少个人
     * @param start 从第几个人开始报数
     * @param step 每次报多少个数
     */
    public void josephusCircle(ListNode head, int n, int start, int step) {
        // 获取到起点节点，从1开始遍历到 start 的位置
        ListNode p = head;
        for (int i = 1; i < start; i++) {
            p = p.next;
        }
        ListNode startNode = p;
        for (int i = 1; i <= n; i++) {
            startNode = countAndRemove(startNode, step);
        }
        startNode.next = null;
        System.out.println();
    }
}
