package com.algorithm.tree.interview;

import com.algorithm.common.datastructure.primitive.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author QingFan 2021/10/2
 * @version 1.0.0
 */
public class PrintBinaryTree {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 生成一个 list，用来保存输出的节点
        List<Integer> list = new ArrayList<>();
        // 首先让根节点入队
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.value);
            // 判断该节点是否有左右子节点
            // 如果左子节点有值，则把左子节点加入到队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            // 如果右子节点有值，则把右子节点加入到队列中
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        // 根据题目要求，把 list 转化为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        // 返回 res
        return res;
    }
}
