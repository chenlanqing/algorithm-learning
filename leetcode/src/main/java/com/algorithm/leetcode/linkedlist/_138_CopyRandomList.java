package com.algorithm.leetcode.linkedlist;

import com.algorithm.common.datastructure.primitive.ListNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月12日 13:32
 */
public class _138_CopyRandomList {

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printList(head);

        Node node = copyRandomList_1(head);

        printList(node);
    }

    /**
     * 将复制的的节点变为源节点的下一个节点
     *
     * 比如有如下结构
     *
     * @param head
     * @return
     */
    public static Node copyRandomList_1(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        Node tmp;
        while (p != null) {
            tmp = p.next;
            p.next = new Node(p.val);
            p.next.next = tmp;
            p = tmp;
        }
        printList(head);
        p = head;
        Node n;
        while (p != null) {
            tmp = p.next.next;
            n = p.next;
            n.random = p.random != null ? p.random.next : null;
            p = tmp;
        }
        printList(head);
        p = head;
        Node res = head.next;
        while (p != null) {
            tmp = p.next.next;
            n = p.next;
            p.next = tmp;
            n.next = tmp != null ? tmp.next : null;
            p = tmp;
        }
        return res;
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }

        p = head;

        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public static void printList(Node head) {
        Node p = head;
        while (p != null) {
            int value = p.val;
            Node random = p.random;
            if (random == null) {
                System.out.print(value + "( N )--> ");
            } else {
                System.out.print(value + "( " + random.val + " )--> ");
            }
            p = p.next;
        }
        System.out.println();
    }

    static class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
