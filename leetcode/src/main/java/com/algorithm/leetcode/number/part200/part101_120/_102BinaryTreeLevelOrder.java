package com.algorithm.leetcode.number.part200.part101_120;

import java.util.*;

/**
 * LeetCode 102题
 * <p>
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * @author bluefish 2019-04-05
 * @version 1.0.0
 */
public class _102BinaryTreeLevelOrder {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            // 首先取出队列的长度，此时的队列的长度是等于树的一层的节点数
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // 逐个取出队首元素，并分别判断队首元素的左、右子节点是否为空，如果不为空，则入队；
                TreeNode node = q.remove();
                level.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
