package com.algorithm.tree.traverse;

import com.algorithm.common.datastructure.primitive.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历-层序遍历基本实现
 *
 * @author bluefish 2019-04-05
 * @version 1.0.0
 */
public class LevelOrderTraverse {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        // 构建一棵树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
