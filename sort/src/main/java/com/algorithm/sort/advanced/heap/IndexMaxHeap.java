package com.algorithm.sort.advanced.heap;


import com.algorithm.utils.ArrayUtils;

/**
 * 索引堆：索引和索引对应的数据两个数组，使用索引数组来构建堆。
 * 创建堆时，真正比较的数据是索引对应的数据，而交换数据真正交换的是索引
 */
public class IndexMaxHeap {
    private int[] data;// 比较大小的数据
    private int[] indexes;// 对应数据的索引，由索引数组来构建堆
    private int[] reverse;
    private int count;// 数据的个数
    private int capacity;//数组的容量

    public IndexMaxHeap(int capacity) {
        data = new int[capacity + 1];// 从1开始存储数据
        indexes = new int[capacity + 1];// 从1 开始表示对应的索引
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
        }
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 对于用户而言，index 表示数组的索引，是从 0 开始的，而实现中构建堆时从1 开始的，这里需要作特殊处理
     *
     * @param index
     * @param t
     */
    public void insert(int index, int t) {
        assert count + 1 <= capacity;
        assert index + 1 >= 1 && index + 1 <= capacity;
        index++;// 从1 开始存储数据
        data[index] = t;
        indexes[count + 1] = index;
        reverse[index] = count + 1;
        count++;
        // 将 新增的元素至于正确的位置
        shiftUp(count);
    }

    /**
     * 最大值
     *
     * @return
     */
    public int extractMax() {
        assert count > 0;
        int ret = data[indexes[1]];
        ArrayUtils.exchange(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    /**
     * 最大值对于的索引
     *
     * @return
     */
    public int extractMaxIndex() {
        assert count > 0;
        int ret = indexes[1] - 1;
        ArrayUtils.exchange(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    public int getMax() {
        assert count > 0;
        return data[indexes[1]];
    }

    public int getMax(int index) {
        assert count > 0;
        return data[index];
    }

    /**
     * 将index位置的元素修改为newData
     *
     * @param index
     * @param newData
     */
    public void change(int index, int newData) {
        assert contains(index);
        index++;
        data[index] = newData;

        // 找到indexes[j] = index, j表示data[index]在堆中的位置
        // 之后shiftUp(j), 再shiftDown(j)
        int j = reverse[index];
        shiftDown(j);
        shiftUp(j);
    }

    public boolean contains(int index) {
        assert (index + 1 >= 1 && index + 1 <= capacity);
        return reverse[index + 1] != 0;
    }

    /**
     * 从最底层节点向根节点确认 k 位置的元素所应处于的正确位置
     *
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {
            ArrayUtils.exchange(indexes, k / 2, k);
            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;
            k /= 2;
        }
    }

    /**
     * 从根节点往下确认 k 位置的元素所应处于的正确位置
     *
     * @param k
     */
    public void shiftDown(int k) {
        // 在完全二叉树中，不可能存在一个节点有右节点而没有左节点，判断一个节点有没有子节点只需要判断其有没有左节点
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]]) {
                j = j + 1;
            }
            if (data[indexes[k]] > data[indexes[j]]) {
                break;
            }
            ArrayUtils.exchange(indexes, k, j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }

    }
}
