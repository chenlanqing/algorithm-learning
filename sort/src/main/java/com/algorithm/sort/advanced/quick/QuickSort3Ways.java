package com.algorithm.sort.advanced.quick;

import com.algorithm.utils.ArrayUtils;
import com.algorithm.utils.sort.SortInt;
import com.algorithm.sort.advanced.merge.MergeSortOpt;
import com.algorithm.sort.base.insert.InsertSelectIntOpt;

/**
 * 快速排序:3路快速排序
 */
public class QuickSort3Ways implements SortInt {

    public static void main(String[] args) {
        int n = 1000000;
        System.out.println("随机数组排序:" + n + ", 范围:[0,1000000]");
        int[] arr = ArrayUtils.generateRandomArray(n ,0, 1000000);
        int[] merge = ArrayUtils.copy(arr, n);
        int[] s3ways = ArrayUtils.copy(arr, n);

        ArrayUtils.testSort("MergeSort", new MergeSortOpt(), arr, n);
        ArrayUtils.testSort("QuickSort", new QuickSort(), merge, n);
        ArrayUtils.testSort("QuickSort3Ways", new QuickSort3Ways(), s3ways, n);
        System.out.println("*****************************************************");
        System.out.println("近乎有序数据:" + n + ", 交换次数:100");
        int[] sort = ArrayUtils.generateNearySortArray(n, 100);
        int[] sort1 = ArrayUtils.copy(sort, n);
        int[] sort2 = ArrayUtils.copy(sort, n);

        ArrayUtils.testSort("MergeSort", new MergeSortOpt(), sort, n);
        ArrayUtils.testSort("QuickSort", new QuickSort(), sort1, n);
        ArrayUtils.testSort("QuickSort3Ways", new QuickSort3Ways(), sort2, n);

        System.out.println("*****************************************************");
        System.out.println("随机数组排序:" + n + ", 范围:[0,10]");
        int[] un = ArrayUtils.generateRandomArray(n ,0, 10);
        int[] un1 = ArrayUtils.copy(un, n);
        int[] un2 = ArrayUtils.copy(un, n);
        ArrayUtils.testSort("MergeSort", new MergeSortOpt(), un, n);
        ArrayUtils.testSort("QuickSort", new QuickSort(), un1, n);
        ArrayUtils.testSort("QuickSort3Ways", new QuickSort3Ways(), un2, n);
    }



    @Override
    public void sort(int[] arr, int n) {
        quickSort3Way(arr, 0, n - 1);
    }

    private void quickSort3Way(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        if (right - left <= 15) {
            InsertSelectIntOpt.sort(arr, left, right);
            return;
        }

        // 三路快速排序
        int random = left + (int) (Math.random() * (right - left + 1));
        ArrayUtils.exchange(arr, random, left);
        int temp = arr[left];

        int lt = left, // arr[left+1,lt] < temp
                gt = right + 1,// arr[gt,r] > temp
                i = left + 1;
        while (i < gt) {
            if (arr[i] < temp) {
                ArrayUtils.exchange(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i] > temp){
                // gt 和 i 交换完数据之后,i 位置的元素还没有处理过,所以 i不需要 ++
                ArrayUtils.exchange(arr, gt-1, i);
                gt--;
            } else {
                // arr[i] == temp
                i++;
            }
        }
        ArrayUtils.exchange(arr, left, lt);
        quickSort3Way(arr, left, lt-1);
        quickSort3Way(arr, gt, right);
    }
}
