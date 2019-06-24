package com.algorithm.datastructure.linkedlist;

import java.util.Stack;

/**
 * 逆序打印链表
 *
 * @author bluefish 2019-06-24
 * @version 1.0.0
 */
public class ReversePrintListNode {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToNode(array);

        printListNodeByLoop(head);
    }

    /**
     * 使用循环逆序打印链表：使用栈结构
     * <p>
     * 时间复杂度O(N)，空间复杂度O(N)
     *
     * @param head
     */
    private static void printListNodeByLoop(ListNode head) {
        if (head.next == null) {
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.value);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void printReverseRecursive(ListNode head){
        if(head.next == null){
            return;
        }
        recursive(head.next);
        System.out.println();
    }
    private void recursive(ListNode p){
        if(p!= null){
            recursive(p.next);
            System.out.print(p.value + " ");
        }
    }

}
