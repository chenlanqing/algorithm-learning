package com.algorithm.common.datastructure.primitive;

/**
 * 二叉树的节点
 *
 * @author bluefish 2019-04-05
 * @version 1.0.0
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 通过数组构建一棵树
     *
     * @param arr 数组
     * @param root 节点
     * @param i 数组索引
     * @return 构建好的树的根节点
     */
    public static TreeNode buildTree(int[] arr, TreeNode root, int i) {
        if (i < arr.length) {
            root = new TreeNode(arr[i]);
            // insert left child
            root.left = buildTree(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = buildTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }
}
