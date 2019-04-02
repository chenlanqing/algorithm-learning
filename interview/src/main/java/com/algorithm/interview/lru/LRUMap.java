package com.algorithm.interview.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * https://mp.weixin.qq.com/s/xi1FzmQGGongOB_mMNenXg
 * LRU-算法实现:不依赖LinkedHashMap
 *
 * @author bluefish 2018/4/21
 * @version 1.0.0
 */
public class LRUMap<K, V> {

    private final Map<K, V> cacheMap = new HashMap<>();
    /**
     * 最大缓存大小
     */
    private int cacheSize;

    /**
     * 节点大小
     */
    private int nodeCount;

    /**
     * 头节点
     */
    private Node<K, V> header;

    private Node<K, V> tailer;

    public LRUMap(int cacheSize) {
        this.cacheSize = cacheSize;
        // 头节点下一个节点为空
        this.header = new Node<>();
        header.next = null;
        // 尾节点上一个节点为空
        this.tailer = new Node<>();
        tailer.pre = null;
        // 双向链表,头节点的上一个节点指向尾节点
        header.pre = tailer;
        // 尾节点的下一个节点指向头结点
        tailer.next = header;
    }

    public void put(K key, V value) {
        cacheMap.put(key, value);
        addNode(key, value);
    }

    public V get(K key){
        Node<K,V> node = getNode(key);
        // 将节点移至头节点
        moveToHead(node);
        return  cacheMap.get(key);
    }

    private void moveToHead(Node<K, V> node) {
        // 如果是最后一个节点
        if(node.pre ==null) {
            node.next.pre = null;
            tailer = node.next;
            nodeCount--;
        }
        // 如果本来就是头节点
        if (node.next == null){
            return;
        }
        // 如果处于中间节点
        if (node.pre != null && node.next != null){
            node.pre.next = node.next;
            nodeCount--;
        }
        node = new Node<>(node.getKey(), node.getValue());
        addHead(node);
    }

    /**
     * 链表查询
     *
     * @param key
     * @return
     */
    private Node<K,V> getNode(K key) {
        Node<K, V> node = tailer;
        while (node != null){
            if (node.getKey().equals(key)){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 写入头节点
     *
     * @param key
     * @param value
     */
    private void addNode(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        // 容量满了删除最后一个
        if (cacheSize == nodeCount) {
            delTail();
        }
        // 写入头节点
        addHead(node);
    }

    /**
     * 添加头节点
     *
     * @param node
     */
    private void addHead(Node<K, V> node) {
        header.next = node;
        node.pre = header;

        header = node;
        nodeCount++;

        // 如果写入的数据大于2个,就将初始化的头尾节点删除
        if (nodeCount == 2) {
            tailer.next.next.pre = null;
            tailer = tailer.next.next;
        }
    }

    private void delTail(){
        cacheMap.remove(tailer.getKey());
        tailer.next.pre = null;
        tailer = tailer.next;
        nodeCount --;
    }

    private class Node<K, V> {
        private K key;
        private V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<K,V> node = tailer;
        while (node != null){
            sb.append(node.getKey()).append(":").append(node.getValue()).append("-->");
            node = node.next;
        }
        return sb.toString();
    }
}
