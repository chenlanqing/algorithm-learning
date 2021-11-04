package com.algorithm.interview.offer.day07;

import com.algorithm.common.datastructure.primitive.TreeNode;
import com.algorithm.common.utils.TreeUtils;
import com.sun.source.tree.Tree;

/**
 * @author QingFan 2021/11/4
 * @version 1.0.0
 */
public class _28_SymmetryTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeNode.buildTree(arr, new TreeNode(0), 0);
        TreeNode.preOrder(root);
        System.out.println();
        TreeNode.levelOrder(root);
        System.out.println();
        TreeNode.levelOrder_1(root);
    }

    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * <pre>
     *   1
     *  / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * </pre>
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * <pre>
     *   1
     *  / \
     *   2   2
     *  \   \
     *  3  3
     * </pre>
     *
     *
     * 示例 1：
     *
     * 输入：root = [1,2,2,3,4,4,3] 输出：true 示例 2：
     *
     * 输入：root = [1,2,2,null,3,null,3] 输出：false
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 递归判断左子树和右子树是否对称
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // 如果某根子树的左右两子树同时为空，肯定是对称的，直接返回 true
        if (left == null && right == null) {
            return true;
        }
        // 说明根子树的左右两子树有某子树为空，某子树有值，不对称，返回 false
        if (left == null || right == null) {
            return false;
        }
        // 左子树的值与右子树的值不相等，不对称，返回 false
        if (left.val != right.val) {
            return false;
        }
        // 递归的对比当前节点的左子树的左子树与右子树的右子树、左子树的右子树与右子树的左子树是否对称
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
