package com.algorithm.tree.trie;

import java.util.TreeMap;

class WordDictionary {

    private final Node root;

    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
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
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }
    
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Character nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        }
    }

    private class Node {

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            next = new TreeMap<>();
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }
    }
}