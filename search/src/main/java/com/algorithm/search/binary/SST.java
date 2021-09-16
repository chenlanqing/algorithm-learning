package com.algorithm.search.binary;

/**
 * 顺序搜索树
 */
public class SST<K extends Comparable<K>, V> {

    private Node head;
    private int count;

    public SST() {
        this.head = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(K key, V value) {
        Node node = head;
        while (node != null) {
            if (node.key.compareTo(key) == 0) {
                node.value = value;
            }
            node = node.next;
        }
        // 若顺序表中没有同样大小的key，则创建新节点，将新节点直接插在表头
        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public V search(K key) {
        Node node = head;
        while (node != null) {
            if (node.key.compareTo(key) == 0) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public boolean contains(K key) {
        Node node = head;
        while (node != null) {
            if (node.key.compareTo(key) == 0) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
}
