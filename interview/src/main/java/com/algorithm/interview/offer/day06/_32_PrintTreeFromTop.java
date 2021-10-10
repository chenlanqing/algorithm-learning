package com.algorithm.interview.offer.day06;

import com.algorithm.common.datastructure.primitive.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author QingFan 2021/10/10
 * @version 1.0.0
 */
public class _32_PrintTreeFromTop {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            arr[i++] = num;
        }

        return arr;
    }
}
