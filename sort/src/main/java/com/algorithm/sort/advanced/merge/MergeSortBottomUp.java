package com.algorithm.sort.advanced.merge;

import com.algorithm.utils.ArrayUtils;
import com.algorithm.utils.sort.SortInt;

import java.util.Arrays;

public class MergeSortBottomUp implements SortInt {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = ArrayUtils.generateRandomArray(n, 1, 100);
        System.out.println(Arrays.toString(arr));
        ArrayUtils.testSort("MergeSort", new MergeSortBottomUp(), arr, n);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr, int n) {
        for (int size = 1; size <= n; size += size) {
            for (int i = 0; i + size < n; i += size + size) {
                mergeSort(arr, i, i + size - 1, Math.min(i + size + size - 1, n - 1));
            }
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
