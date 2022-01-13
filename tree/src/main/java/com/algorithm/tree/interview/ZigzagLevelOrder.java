package com.algorithm.tree.interview;

import com.algorithm.common.datastructure.primitive.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月11日 17:04
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        int[] arr = {3, 9, 20, 15, 7};
        root = TreeNode.buildTree(arr, root, 0);
        TreeNode.print(root);
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        boolean flag = false;

        while (!stack.isEmpty()) {
            LinkedList<Integer> t = new LinkedList<>();
            int size = stack.size();

            flag = !flag;
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.poll();
                if (flag) {
                    t.addLast(node.val);
                } else {
                    t.addFirst(node.val);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            res.add(t);
        }
        return res;
    }
}
