package com.algorithm.sort.advanced.quick;

import com.algorithm.common.utils.ArrayUtils;
import com.algorithm.sort.advanced.merge.MergeSortOpt;
import com.algorithm.common.algorithm.sort.SortInt;

/**
 * 快速排序：
 */
public class QuickSort implements SortInt {

    public static void main(String[] args) {
        int n = 1000000;
        int[] arr = ArrayUtils.generateRandomArray(n, 1, 10);
        int[] copy = ArrayUtils.copy(arr, n);
        ArrayUtils.testSort("MergeSortOPt", new MergeSortOpt(), copy, n);
        ArrayUtils.testSort("QuickSort", new QuickSort(), arr, n);

        int[] sort = ArrayUtils.generateNearySortArray(n, 100);
        int[] sort1 = ArrayUtils.copy(sort, n);
        ArrayUtils.testSort("MergeSortOPt", new MergeSortOpt(), sort1, n);
        ArrayUtils.testSort("QuickSort", new QuickSort(), sort, n);
    }

    @Override
    public void sort(int[] arr, int n) {
        quickSort(arr, 0, n - 1);
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition2(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    /**
     * 对arr[l...r]部分进行partition操作
     * 返回p,使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     *
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        int random = left + (int) (Math.random() * (right - left + 1));
        ArrayUtils.exchange(arr, left, random);
        int temp = arr[left];
        // 使得 arr[left+1...j] < temp, arr[j+1...right] > temp
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < temp) {
                ArrayUtils.exchange(arr, j + 1, i);
                j++;
            }
        }
        ArrayUtils.exchange(arr, j, left);
        return j;
    }

    private int partition2(int[] arr, int left, int right) {
        // 随机化取几个索引值
        int random = left + (int) (Math.random() * (right - left + 1));
        ArrayUtils.exchange(arr, left, random);
        int temp = arr[left];
        // 使得 arr[left+1...i) < temp, arr(j...right] > temp
        int i = left + 1, j = right;
        while (true) {
            // 右边遍历
            while (i <= right && arr[i] < temp) {
                i++;
            }
            // 左边遍历
            while (j >= left + 1 && arr[j] > temp) {
                j--;
            }
            if (i > j) {
                break;
            }
            ArrayUtils.exchange(arr, i, j);
            i++;
            j--;
        }
        ArrayUtils.exchange(arr, j, left);
        return j;
    }

}
