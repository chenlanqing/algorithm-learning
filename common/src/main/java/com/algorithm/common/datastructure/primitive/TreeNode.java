package com.algorithm.common.datastructure.primitive;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的节点
 *
 * @author bluefish 2019-04-05
 * @version 1.0.0
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 通过数组构建一棵树
     *
     * @param arr 数组
     * @param root 节点
     * @param i 数组索引
     * @return 构建好的树的根节点
     */
    public static TreeNode buildTree(int[] arr, TreeNode root, int i) {
        if (i < arr.length) {
            root = new TreeNode(arr[i]);
            // insert left child
            root.left = buildTree(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = buildTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void levelOrder_1(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
    }

    public static int heightOf(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(
                heightOf(node.left),
                heightOf(node.right)
        ) + 1;
    }

    public static void print(TreeNode root) {
        int h = heightOf(root);
        int W = 2 * (int) Math.pow(2, h);
        var lines = new StringBuilder[h * 2];
        for (int i = 0; i < h * 2; i++) {
            lines[i] = new StringBuilder(String.format("%" + W + "s", ""));
        }

        printNode(lines, W, root, 0, 0);
        for (var line : lines) {
            System.out.println(line.toString());
        }

    }

    private static void printNode(StringBuilder[] lines, int W, TreeNode node, int h, int base) {
        var nums = Math.pow(2, h);
        var pos = base + (int) (W / (nums * 2));

        var str = String.valueOf(node.val);
        for (int i = 0; i < str.length(); i++) {
            lines[h * 2].setCharAt(pos + i, str.charAt(i));
        }

        if (node.left != null) {
            lines[h * 2 + 1].setCharAt(pos - 1, '/');
            printNode(lines, W, node.left, h + 1, base);
        }

        if (node.right != null) {
            lines[h * 2 + 1].setCharAt(pos + str.length() + 1, '\\');
            printNode(lines, W, node.right, h + 1, pos);
        }
    }

}
