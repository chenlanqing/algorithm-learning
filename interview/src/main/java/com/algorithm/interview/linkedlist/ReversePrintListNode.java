package com.algorithm.interview.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;
import java.util.Stack;

/**
 * 逆序打印链表
 *
 * <p>
 * 方法1：使用额外的空间（栈来实现）{@link ReversePrintListNode#reverseNode}
 * <p>
 * 方法2：使用递归来实现 {@link ReversePrintListNode#recursiveReverseNode}
 *
 * @author bluefish 2019-06-24
 * @version 1.0.0
 */
public class ReversePrintListNode {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToNode(array);

        reverseNode(head);

        System.out.println();

        recursiveReverseNode(head);
    }

    /**
     * 使用递归来实现：时间复杂度：O(N)，空间复杂度：O(1)
     *
     * @param head
     */
    public static void recursiveReverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        recursive(head);
    }

    private static void recursive(ListNode p) {
        if (p != null) {
            recursive(p.next);
            System.out.print(p.val + "    ");
        }
    }

    /**
     * 使用栈来反转，时间复杂度：O(N)，空间复杂度：O(N)
     *
     * @param head
     */
    public static void reverseNode(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode p = head;

        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "    ");
        }
        System.out.println();
    }
}
