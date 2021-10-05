package com.algorithm.sort;

import com.algorithm.common.utils.ArrayUtils;
import com.algorithm.sort.advanced.heap.HeapSort1;
import com.algorithm.sort.advanced.heap.HeapSort2;
import com.algorithm.sort.advanced.merge.MergeSortOpt;
import com.algorithm.sort.advanced.quick.QuickSort;
import com.algorithm.sort.advanced.quick.QuickSort3Ways;
import org.junit.Test;

public class TestAdvancedSort {

    static final int N = 10000;

    @Test
    public void test1RandomArray(){
        int[] merge = ArrayUtils.generateRandomArray(N, 0 ,N);
        int[] quick1 = ArrayUtils.copy(merge, N);
        int[] quick2 = ArrayUtils.copy(merge, N);
        int[] heap1 = ArrayUtils.copy(merge, N);
        int[] heap2 = ArrayUtils.copy(merge, N);
        ArrayUtils.testSort("MergeSort", new MergeSortOpt(), merge, N);
        ArrayUtils.testSort("QuickSort", new QuickSort(), quick1, N);
        ArrayUtils.testSort("QuickSort3Ways", new QuickSort3Ways(), quick2, N);
        ArrayUtils.testSort("Heap Sort 1", new HeapSort1(), heap1, N);
        ArrayUtils.testSort("Heap Sort 2", new HeapSort2(), heap2, N);
        System.out.println("***********************************************");
    }

    @Test
    public void test2NearlyArray(){
        int[] merge = ArrayUtils.generateNearySortArray(N, 0);
        int[] quick1 = ArrayUtils.copy(merge, N);
        int[] quick2 = ArrayUtils.copy(merge, N);
        int[] heap1 = ArrayUtils.copy(merge, N);
        int[] heap2 = ArrayUtils.copy(merge, N);
        ArrayUtils.testSort("MergeSort", new MergeSortOpt(), merge, N);
        ArrayUtils.testSort("QuickSort", new QuickSort(), quick1, N);
        ArrayUtils.testSort("QuickSort3Ways", new QuickSort3Ways(), quick2, N);
        ArrayUtils.testSort("Heap Sort 1", new HeapSort1(), heap1, N);
        ArrayUtils.testSort("Heap Sort 2", new HeapSort2(), heap2, N);
        System.out.println("***********************************************");
    }

    @Test
    public void test3RandomArray(){
        int[] merge = ArrayUtils.generateRandomArray(N, 0 ,N);
        int[] quick1 = ArrayUtils.copy(merge, N);
        int[] quick2 = ArrayUtils.copy(merge, N);
        int[] heap1 = ArrayUtils.copy(merge, N);
        int[] heap2 = ArrayUtils.copy(merge, N);
        ArrayUtils.testSort("MergeSort", new MergeSortOpt(), merge, N);
        ArrayUtils.testSort("QuickSort", new QuickSort(), quick1, N);
        ArrayUtils.testSort("QuickSort3Ways", new QuickSort3Ways(), quick2, N);
        ArrayUtils.testSort("Heap Sort 1", new HeapSort1(), heap1, N);
        ArrayUtils.testSort("Heap Sort 2", new HeapSort2(), heap2, N);
        System.out.println("***********************************************");
    }
}
