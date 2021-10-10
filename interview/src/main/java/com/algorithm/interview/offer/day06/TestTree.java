package com.algorithm.interview.offer.day06;

import com.algorithm.common.datastructure.generic.TreeNode;
import com.algorithm.common.utils.TreeUtils;

/**
 * @author QingFan 2021/10/10
 * @version 1.0.0
 */
public class TestTree {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, null, null, 5};
        TreeNode<Integer> root = TreeUtils.buildTree(arr, new TreeNode<>(), 0);
        TreeUtils.print(root);
    }
}
