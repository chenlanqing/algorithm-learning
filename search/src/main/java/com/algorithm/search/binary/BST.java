package com.algorithm.search.binary;

import java.util.LinkedList;

/**
 * 二叉搜索树：<br/>
 * (1).是一颗二叉树;<br/>
 * (2).每个节点的键值大于左子节点;<br/>
 * (3).每个节点的键值小于右子节点;<br/>
 * (4).以左右子节点为根的树仍为二分搜索树<br/>
 * (5).右子节点的键值全部大于左子几点
 *
 * @param <K>
 * @param <V>
 */
public class BST<K extends Comparable<K>, V> {

    //根节点
    private Node root;
    //树中节点个数
    private int count;

    public BST() {
        this.root = null;
        this.count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // 查询

    /**
     * 搜索数据
     *
     * @param key
     * @return
     */
    public V search(K key) {
        return search(root, key);
    }

    private V search(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) == 0) {
            return node.value;
        }
        if (node.key.compareTo(key) > 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    /**
     * 是否包含Key
     *
     * @param key
     * @return
     */
    public boolean contain(K key) {
        return contain(root, key);
    }

    private boolean contain(Node node, K key) {
        if (node == null) {
            return false;
        }
        if (node.key.compareTo(key) == 0) {
            return true;
        }

        if (node.key.compareTo(key) > 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    /**
     * 获取树种最小值。即判断节点是否还有左子节点，如果没有，则该节点为整颗二分查找树的最小值
     *
     * @return
     */
    public K minimum() {
        assert count != 0;//树不能为空
        Node min = minimum(root);
        return min.key;
    }

    /**
     * 查询以node为根节点的二叉搜索树中，最小值
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        // 使用递归
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
        // 不使用的递归
//        while (node.left != null){
//            node = node.left;
//        }
//        return node;
    }

    /**
     * 获取树种最大值。即判断节点是否还有右子节点，如果没有，则该节点为整颗二分查找树的最大值
     *
     * @return
     */
    public K maximum() {
        assert count != 0;
        Node node = maximum(root);
        return node.key;
    }

    /**
     * 查询以node为根节点的二叉搜索树中，最大值
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    // 对树进行操作：增、删、改

    /**
     * 往二叉搜索树插入记录
     *
     * @param key
     * @param value
     */
    public void insert(K key, V value) {
        root = recursiveInsert(root, key, value);
    }

    /**
     * 递归插入:向以node为根的二分搜索树中, 插入节点(key, value), 使用递归算法
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node recursiveInsert(Node node, K key, V value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        if (node.key.compareTo(key) == 0) {
            node.value = value;
        } else if (node.key.compareTo(key) > 0) {
            node.left = recursiveInsert(node.left, key, value);
        } else {
            node.right = recursiveInsert(node.right, key, value);
        }
        return node;
    }

    /**
     * 非递归插入数据
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node node, K key, V value) {
        //TODO
        return node;
    }

    /**
     * 删除二叉搜索树种的最小值
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 删除以node为根节点的二叉搜索树中的最小值
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;//for gc
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二叉搜索树种的最大值
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点,返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二叉搜索树中删除键值为 key 的节点
     *
     * @param key
     */
    public void remove(K key) {
        root = remove(root, key);
    }

    /**
     * 删除掉以node为根的二分搜索树中键值为key的节点,返回删除节点后新的二分搜索树的根.分三种情况处理:<br/>
     * (1).需要删除的 key 是叶子节点,直接删除该节点;<br/>
     * (2).需要删除的 key 只有一个子节点(左子节点或右子节点),将其子节点与父节点相连即可;<br/>
     * (3).需要删除的 key 左右子节点都不为空,有个著名的算法 Hubbard Deletion.该算法策略是:<br/>
     * 使用删除节点的右子树中最小的值替代该节点,并删除掉右子树中最小的值.<br/>
     * 或者是使用要删除节点中左子树中最大值替代该节点,并删除左子树中最大的值
     *
     * @param node 根节点
     * @param key  需要删除的节点
     * @return 返回删除后新的节点
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // key == node.key
            if (node.left == null) { // 左子节点为空
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }

            if (node.right == null) { // 右子节点为空
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            // 左右子节点都不为空的

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node success = new Node(minimum(node.right));
            count++;

            // 将节点重新绑定
            success.right = removeMin(node.right);
            success.left = node.left;

            count--;
            node.left = node.right = null;

            return success;
        }
    }

    // 遍历

    /**
     * 求树的最高高度
     *
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node node) {
        if (node != null) {
            midOrder(node.left);
            System.out.print(node.key + " ");
            midOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    /**
     * 根据前序遍历和中序遍历构造出二叉树，前序遍历第一个节点是根节点，根据该根节点找到其在中序遍历的位置，该位置的左边是根节点的左子树部分，右边是右子树部分；
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
//    public Node createTreeFromPreOrderAndMidOrder(String preOrder, String inOrder) {
//        if (preOrder == null || preOrder.isEmpty()) {
//            return null;
//        }
//
//        char rootValue = preOrder.charAt(0);
//        int rootIndex = inOrder.indexOf(rootValue);
//
//        Node root = new Node(rootValue);
//
//        root.left = createTreeFromPreOrderAndMidOrder(preOrder.substring(1, 1 + rootIndex), inOrder.substring(0, rootIndex));
//        root.right = createTreeFromPreOrderAndMidOrder(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex));
//
//        return root;
//    }

    /**
     * 层序遍历二分搜索树:借助队列先进先出的特性
     */
    public void levelOrder() {

        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.key + " ");
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 反转二叉树
     *
     * @return
     */
    Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


    /**
     * 数的节点结构
     */
    public class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.right = node.right;
            this.left = node.left;

        }
    }
}
