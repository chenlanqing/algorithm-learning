package com.algorithm.common.datastructure.generic;

/**
 * @author QingFan 2021/10/5
 * @version 1.0.0
 */
public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.value = value;
    }
}
