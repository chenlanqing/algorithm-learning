package com.algorithm.sort.advanced.heap;

import com.algorithm.common.algorithm.sort.SortInt;
import com.algorithm.common.utils.ArrayUtils;

/**
 * Created by BlueFish on 2017/5/6.
 */
public class HeapSort implements SortInt {
    public static void main(String[] args) {
        int N = 1000000;
        int[] merge = ArrayUtils.generateRandomArray(N, 0, N);
        int[] copy = ArrayUtils.copy(merge, N);
        ArrayUtils.testSort("Heap Sort 2", new HeapSort2(), merge, N);
        ArrayUtils.testSort("Heap Sort 3", new HeapSort(), copy, N);

    }

    @Override
    public void sort(int[] arr, int n) {
        // 从第一个非叶子节点构建一个二叉堆
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        // 二叉堆第一个元素是最大的，跟第一个元素互换位置，然后再讲n-2前面的元素继续构建二叉堆
        for (int i = n - 1; i > 0; i--) {
            ArrayUtils.exchange(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    private void shiftDown(int[] arr, int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j += 1;
            }
            if (arr[k] > arr[j]) {
                break;
            }
            ArrayUtils.exchange(arr, j, k);
            k = j;
        }
    }
}
