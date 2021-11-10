package com.algorithm.tree.interview;

import com.algorithm.common.datastructure.generic.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * @author QingFan 2021/10/2
 * @version 1.0.0
 */
public class PrintBinaryTree2 {

    public List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        // 设置 res 用来保存输出结果
        List<List<Integer>> res = new LinkedList<>();
        // 边界情况处理
        if (root == null) {
            return res;
        }
        // 设置一个队列，用来存储二叉树中的元素
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        // 队列添加二叉树的根节点
        queue.add(root);
        // 遍历队列，直到队列为空，说明访问了二叉树中所有的节点
        while (!queue.isEmpty()) {
            // 用来记录 queue 的长度，即每层节点的个数
            int size = queue.size();
            // 用来保存每一层节点，保存成功后添加到 res 中
            List<Integer> temp = new ArrayList<>();
            // 使用 for 循环，将 queue 中的元素添加的 temp 中
            for (int i = 0; i < size; i++) {
                // 从 queue 中取出一个节点
                TreeNode<Integer> node = queue.poll();
                // 把节点存放到 list 中
                temp.add(node.val);  //将节点值加入list
                // 判断当前节点的左子节点是否有值，如果有，则添加到 queue 中
                if (node.left != null) {
                    queue.add(node.left);
                }
                // 判断当前节点的右子节点是否有值，如果有，则添加到 queue 中
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 把存放了每一层元素的数组 temp 添加到 res 中
            res.add(temp);
        }
        return res;
    }
}
