package com.algorithm.interview.offer.day02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author QingFan 2021/10/6
 * @version 1.0.0
 */
public class _35_CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;

        while (cur != null) {
            Node valueCur = map.get(cur);
            Node keyNextNode = cur.next;
            valueCur.next = map.get(keyNextNode);
            Node keyRandom = cur.random;
            valueCur.random  = map.get(keyRandom);
            cur = cur.next;
        }

        return map.get(head);
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
