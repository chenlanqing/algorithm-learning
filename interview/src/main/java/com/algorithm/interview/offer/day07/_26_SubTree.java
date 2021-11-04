package com.algorithm.interview.offer.day07;

import com.algorithm.common.datastructure.primitive.TreeNode;

/**
 * 二叉树具备天然的递归性，B 与 A 根节点的比较、 B 与 A 左右子树的比较、B 左右子节点与 A 左右子树的子节点的比较代码是一样
 *
 * @author QingFan 2021/11/4
 * @version 1.0.0
 */
public class _26_SubTree {

    public static void main(String[] args) {
        _26_SubTree s = new _26_SubTree();
        TreeNode A = TreeNode.buildTree(new int[]{1, 2, 3, 4}, new TreeNode(0), 0);
        TreeNode B = TreeNode.buildTree(new int[]{3}, new TreeNode(0), 0);

        System.out.println(s.isSubStructure(A, B));
    }

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 例如: 给定的树 A:
     * <pre>
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * </pre>
     * 给定的树 B：
     * <pre>
     *    4
     *   /
     *  1
     *  </pre>
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * 示例 1：
     *
     * 输入：A = [1,2,3], B = [3,1] 输出：false
     *
     * 示例 2：
     *
     * 输入：A = [3,4,5,1,2], B = [4,1] 输出：true
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 一开始如果 A 或者 B 为空，直接返回 false
        // 因为题目约定空树不是任意一个树的子结构
        if (A == null || B == null) {
            return false;
        }
        // 接下来去以下几种情况
        // A 的根节点 VS B 的根节点（ A 的左右子树的节点 VS B 的根节点）
        // 1、A 的根节点和 B 的根节点相同情况，依次比较它们的子节点
        // 2、A 的根节点和 B 的根节点不相同情况， A 的左子树 VS B 的根节点
        // 3、A 的根节点和 B 的根节点不相同情况， A 的右子树 VS B 的根节点
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean isSub(TreeNode A, TreeNode B) {
        // A 和 B 不匹配的情况有很多，我们需要一开始去找它们完全匹配的情况
        // 即遍历完 B ，直到为 null，说明 B 的全部节点都和 A 的子结构匹配上
        if (B == null) {
            return true;
        }
        // A 中的节点为空，但 B 中的节点不为空，说明不匹配
        if (A == null) {
            return false;
        }

        // A 和 B 都不为空 ，但数值不同，说明不匹配
        if (A.val != B.val) {
            return false;
        }
        // 此时，当前这个点是匹配的，继续递归判断左子树和右子树是否「分别匹配」
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}
