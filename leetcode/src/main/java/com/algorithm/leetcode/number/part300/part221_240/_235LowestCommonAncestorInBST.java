package com.algorithm.leetcode.number.part300.part221_240;

import com.algorithm.leetcode.TreeNode;

/**
 * 给定一颗二分搜索树和两个节点，寻找着两个节点最近公共祖先；<br/>
 *
 * <pre>
 *
 *                 62
 *             /        \
 *         30            80
 *       /    \        /    \
 *    19      28     63     90
 *   /  \    /
 * 16   21 22
 * </pre>
 * 上述二叉树中
 * <li>求节点30和80的最近公共祖先，因为30小于60，而80大于60，则其公共祖先是60</li>
 * <li>求节点30和28的最近公共祖先，因为30和28都是小于62，所以在根节点的左侧查询，由于30是28的根节点，所以这两个节点的最近公共祖先是30</li>
 *
 * @author bluefish 2019-04-06
 * @version 1.0.0
 */
public class _235LowestCommonAncestorInBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        assert p != null && q != null;

        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
