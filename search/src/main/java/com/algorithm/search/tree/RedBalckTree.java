package com.algorithm.search.tree;

/**
 * 红黑树：平衡二叉树
 */
public class RedBalckTree<K extends Comparable<K>, V> {


    private class Node<K, V> {
        private K key;
        private V value;
        private Node left; //左子树
        private Node right;//右子树
        private Node parent;//父节点
        private boolean isRed;//是否为红色节点
    }



}
