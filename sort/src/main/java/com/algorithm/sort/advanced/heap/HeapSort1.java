package com.algorithm.sort.advanced.heap;

import com.algorithm.utils.ArrayUtils;
import com.algorithm.utils.sort.SortInt;

/**
 * 基础堆排序
 */
public class HeapSort1 implements SortInt {

    public static void main(String[] args) {
        int n = 10000;
        int[] arr = ArrayUtils.generateNearySortArray(n, 100);
        ArrayUtils.testSort("Heap Sort 1", new HeapSort1(), arr, n);
    }


    @Override
    public void sort(int[] arr, int n) {
        MaxHeap heap = new MaxHeap(n);
        for (int i = 0; i < n; i++) {
            heap.insert(arr[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = heap.extractMax();
        }
    }
}
