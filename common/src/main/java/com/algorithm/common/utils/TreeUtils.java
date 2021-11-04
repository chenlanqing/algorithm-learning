package com.algorithm.common.utils;

import com.algorithm.common.datastructure.generic.TreeNode;
import java.util.List;

/**
 * @author QingFan 2021/10/5
 * @version 1.0.0
 */
public class TreeUtils {

    /**
     * 前序遍历
     *
     * @param root 根节点
     * @param list 遍历的数据存放到集合
     */
    public static <T> void preOrder(TreeNode<T> root, List<T> list) {
        if (root == null) {
            return;
        }
        list.add(root.value);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    /**
     * 前序遍历
     *
     * @param root 根节点
     */
    public static <T> void preOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     * @param list 遍历的数据存放到集合
     */
    public static <T> void inOrder(TreeNode<T> root, List<T> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.value);
        inOrder(root.right, list);
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public static <T> void postOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     * @param list 遍历的数据存放到集合
     */
    public static <T> void postOrder(TreeNode<T> root, List<T> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.value);
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public static <T> void inOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    /**
     * 通过数组构建一棵树
     *
     * @param arr 数组
     * @param root 节点
     * @param i 数组索引
     * @param <T> 泛型
     * @return 构建好的树的根节点
     */
    public static <T> TreeNode<T> buildTree(T[] arr, TreeNode<T> root, int i) {
        if (i < arr.length) {
            if (arr[i] == null) {
                return root;
            }
            root = new TreeNode<>(arr[i]);
            // insert left child
            root.left = buildTree(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = buildTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static <T> int heightOf(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(
                heightOf(node.left),
                heightOf(node.right)
        ) + 1;
    }

    public static <T> void print(TreeNode<T> root) {
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

    private static <T> void printNode(StringBuilder[] lines, int W, TreeNode<T> node, int h, int base) {
        var nums = Math.pow(2, h);
        var pos = base + (int) (W / (nums * 2));

        var str = node.value.toString();
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
