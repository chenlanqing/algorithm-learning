package com.algorithm.sort.advanced.merge;

import com.algorithm.common.utils.ArrayUtils;
import com.algorithm.common.algorithm.sort.SortInt;
import com.algorithm.sort.base.insert.InsertSelectIntOpt;

/**
 * 归并排序优化
 */
public class MergeSortOpt implements SortInt {
    public static void main(String[] args) {
        int n = 5000000;
        int[] arr = ArrayUtils.generateNearySortArray(n, 0);
        int[] insert = ArrayUtils.copy(arr, n);
        ArrayUtils.testSort("MergeSort", new MergeSortOpt(), arr, n);
        ArrayUtils.testSort("InsertionSort", new InsertSelectIntOpt(), insert, n);

    }

    @Override
    public void sort(int[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (right - left <= 15) {
            InsertSelectIntOpt.sort(arr, left, right);
            return;
        }
        int mid = (right + left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        // 优化思路:如果mid的值小于mid+1的值说明已经有序了
        if (arr[mid] > arr[mid + 1]) {
            mergeSort(arr, left, mid, right);
        }
    }

    private void mergeSort(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];

        for (int i = left; i <= right; i++) {
            help[i - left] = arr[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = help[j - left];
                j++;
            } else if (j > right) {
                arr[k] = help[i - left];
                i++;
            } else if (help[i - left] > help[j - left]) {
                arr[k] = help[j - left];
                j++;
            } else {
                arr[k] = help[i - left];
                i++;
            }
        }
    }
}
