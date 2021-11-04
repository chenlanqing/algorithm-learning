package com.algorithm.interview.offer.day07;

import com.algorithm.common.datastructure.primitive.TreeNode;

/**
 * @author QingFan 2021/11/4
 * @version 1.0.0
 */
public class _27_TreeMirror {

    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     * <pre>
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * </pre>
     * 镜像输出：
     * <pre>
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * </pre>
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9] 输出：[4,7,2,9,6,3,1]
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        mirrorTree(left);
        mirrorTree(right);
        return root;
    }

    private void exchange(TreeNode left, TreeNode right) {

    }
}
