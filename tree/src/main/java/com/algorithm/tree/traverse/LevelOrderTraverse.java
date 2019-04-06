package com.algorithm.tree.traverse;

import com.algorithm.tree.common.BinaryTreeNode;

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
        BinaryTreeNode root = new BinaryTreeNode(10);
        // 构建一棵树
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
