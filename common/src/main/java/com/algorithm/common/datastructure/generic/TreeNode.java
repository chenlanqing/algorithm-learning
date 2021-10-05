package com.algorithm.common.datastructure.generic;

/**
 * @author QingFan 2021/10/5
 * @version 1.0.0
 */
public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public <T> int heightOf(TreeNode<T> node) {
        if(node == null) {
            return 0;
        }
        return Math.max(
                heightOf(node.left),
                heightOf(node.right)
        ) + 1;
    }
}
