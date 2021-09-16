package com.algorithm.sort.advanced.heap;

import com.algorithm.utils.ArrayUtils;
import com.algorithm.utils.sort.SortInt;

/**
 * 开辟了额外的数组空间
 */
public class HeapSort2 implements SortInt {

    public static void main(String[] args) {
        int n = 1000000;
        int[] arr = ArrayUtils.generateNearySortArray(n, 100);
        int[] arr1 = ArrayUtils.copy(arr, n);
        ArrayUtils.testSort("Heap Sort 1", new HeapSort1(), arr, n);
        ArrayUtils.testSort("Heap Sort 2", new HeapSort2(), arr1, n);
    }

    @Override
    public void sort(int[] arr, int n) {
        MaxHeap heap = new MaxHeap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = heap.extractMax();
        }
    }
}
