package com.algorithm.leetcode.number.part500.part421_440;

import com.algorithm.leetcode.TreeNode;

/**
 * @author bluefish 2019-04-06
 * @version 1.0.0
 */
public class _437PathSum3 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    /**
     * 以Node为根节点的二叉树中，寻找包含node的路径，和为sum，返回其路径个数
     * @param node
     * @param sum
     * @return
     */
    private int findPath(TreeNode node, int sum) {
        if(node == null) {
            return 0;
        }

        int res = 0;

        if (node.val == sum) {
            res += 1;
        }

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }
}
