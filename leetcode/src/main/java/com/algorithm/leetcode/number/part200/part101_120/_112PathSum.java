package com.algorithm.leetcode.number.part200.part101_120;

import com.algorithm.common.datastructure.primitive.TreeNode;

/**
 * 给出一颗二叉树一级一个数字sum
 *
 * @author bluefish 2019-04-06
 * @version 1.0.0
 */
public class _112PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        if (hasPathSum(root.left, sum - root.val)){
            return true;
        }

        if (hasPathSum(root.right, sum - root.val)) {
            return true;
        }

        return false;
    }
}
