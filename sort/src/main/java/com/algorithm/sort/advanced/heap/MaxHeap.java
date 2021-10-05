package com.algorithm.sort.advanced.heap;


import com.algorithm.common.utils.ArrayUtils;

/**
 * 最大堆：完全二叉树
 * 父节点的值大于子节点，先有左子节点后有右子节点
 * 在完全二叉树中，不可能存在一个节点有右节点而没有左节点
 * 对于完全二叉树，第一个不是叶子节点的索引为：count /2
 * 注意：这里堆的是从索引 1 开始的
 * <pre>
 *
 *                 62
 *             /        \
 *         41            30
 *       /    \        /    \
 *    28      16     22     13
 *   /  \    /
 * 19   17  15
 * </pre>
 *
 */
public class MaxHeap {
    private int[] data;// 存储数据的结构
    private int count;// 数据的个数
    private int capacity;//数组的容量

    public MaxHeap(int capacity) {
        data = new int[capacity + 1];// 从1开始存储数据
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(int[] arr, int n) {
        data = new int[n + 1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 新元素是添加到数据的末位
     *
     * @param t
     */
    public void insert(int t) {
        assert count + 1 <= capacity;
        data[count + 1] = t;
        count++;
        // 将 新增的元素至于正确的位置
        shiftUp(count);
    }

    public int extractMax() {
        assert count > 0;
        int ret = data[1];
        ArrayUtils.exchange(data, 1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    /**
     * 从最底层节点向根节点确认 k 位置的元素所应处于的正确位置，节点k对应的父节点应该是：k/2
     *
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2] < data[k]) {
            ArrayUtils.exchange(data, k / 2, k);
            k /= 2;
        }
    }

    /**
     * 从根节点往下确认 k 位置的元素所应处于的正确位置，节点ke的左子节点是：2*k、右子节点是2*k+1
     *
     * @param k
     */
    private void shiftDown(int k) {
        // 在完全二叉树中，不可能存在一个节点有右节点而没有左节点，判断一个节点有没有子节点只需要判断其有没有左节点
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1] > data[j]) {
                j = j + 1;
            }
            if (data[k] > data[j]) {
                break;
            }
            ArrayUtils.exchange(data, k, j);
            k = j;
        }

    }

    public void print() {
        System.out.println("The heap size is: " + size());
        System.out.print("data in heap: ");
        for (int i = 1; i <= size(); i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private String generateNString(int n, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
