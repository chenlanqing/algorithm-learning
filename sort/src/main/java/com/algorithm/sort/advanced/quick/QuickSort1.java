package com.algorithm.sort.advanced.quick;

import com.algorithm.common.utils.ArrayUtils;
import com.algorithm.sort.advanced.merge.MergeSortOpt;
import com.algorithm.common.algorithm.sort.SortInt;

/**
 * @author QingFan 2021/10/4
 * @version 1.0.0
 */
public class QuickSort1 implements SortInt {

    public static void main(String[] args) {
        int n = 100000;
        int[] arr = ArrayUtils.generateRandomArray(n, 1, 10);
        int[] copy = ArrayUtils.copy(arr, n);
        ArrayUtils.testSort("MergeSortOPt", new MergeSortOpt(), copy, n);
        ArrayUtils.testSort("QuickSort", new QuickSort1(), arr, n);

        int[] sort = ArrayUtils.generateNearySortArray(n, 100);
        int[] sort1 = ArrayUtils.copy(sort, n);
        ArrayUtils.testSort("MergeSortOPt", new MergeSortOpt(), sort1, n);
        ArrayUtils.testSort("QuickSort", new QuickSort1(), sort, n);
    }

    @Override
    public void sort(int[] arr, int n) {
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(int[] A, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        // 选择最左边的元素构造子问题集合
        // 小于x的放到左边，大于x的放到右边
        // int x = A[l];
        // i代表x的位置
        int i = partition(A, left, right);

        quickSort(A, left, i);
        quickSort(A, i + 1, right);
    }

    private int partition(int[] A, int left, int right) {
        int temp = A[left];
        int i = left + 1, j = right;

        while (i != j) {
            if (A[i] < temp) {
                i++;
            } else {
                ArrayUtils.exchange(A, i, --j);
            }
        }
        ArrayUtils.exchange(A, i - 1, left);
        return i - 1;
    }

}
