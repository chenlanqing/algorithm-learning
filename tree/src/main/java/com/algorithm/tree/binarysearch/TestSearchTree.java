package com.algorithm.tree.binarysearch;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月10日 12:49
 */
public class TestSearchTree {

    public static void main(String[] args) {
//        int[] arr = {28, 16, 30, 13, 22, 29, 42};
        int[] arr = {41, 22, 58, 60, 59, 63, 50, 15, 42, 53, 33, 37, 13, 18, 28};
//        int[] arr = {41, 22, 58, 50, 15, 42, 53, 33, 37, 13};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int num : arr) {
            bst.add(num);
        }
        bst.print();
//        System.out.println(bst.max());
//        System.out.println(bst.min());
//        System.out.println(bst.removeMax());
//        bst.print();
//        System.out.println(bst.removeMin());
//        bst.print();

//        System.out.println("前序遍历");
//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNotRecursive();
//        System.out.println();
//
//        System.out.println("中序遍历");
//        bst.inOrder();
//        System.out.println();
//        bst.inOrderNotRecursive();
//        System.out.println();
//
//        System.out.println("后序遍历");
//        bst.postOrder();
//        System.out.println();
//        bst.postOrderNotRecursive();
//        System.out.println();
//
//        System.out.println("层序遍历");
//        bst.levelOrder();
//        System.out.println();
    }
}
