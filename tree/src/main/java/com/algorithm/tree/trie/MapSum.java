package com.algorithm.tree.trie;

import java.util.TreeMap;

class MapSum {

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String word, int val) {
        Node cur = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        // 判断当前cur是否为单词，如果不是，则需要将cur的isWord设置为true，然后size+1
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.value;
        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }

    private class Node {

        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value) {
            next = new TreeMap<>();
            this.value = value;
        }

        public Node() {
            this(0);
        }
    }
}
