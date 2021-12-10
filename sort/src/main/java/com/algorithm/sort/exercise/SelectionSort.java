package com.algorithm.sort.exercise;

import com.algorithm.common.utils.ArrayUtils;

/**
 * @author QingFan 2021-08-24
 * @version 1.0.0
 */
public class SelectionSort implements IMutableSorter {

    @Override
    public void sort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int min = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(A, min, i);
        }
    }

    public static void main(String[] args) {
        selectionSortDerivation();
    }

    /**
     * 选择排序推导过程
     */
    public static void selectionSortDerivation() {
        // 对如下数组进行排序
        int[] arr = {101, 34, 119, 1};
        ArrayUtils.print(arr, "选择排序初始的顺序=", ",");
        int len = arr.length;
        // 第一轮排序：默认第一个元素为最小，然后从索引1开始遍历，找到最小的索引，将其与min交互
        int i = 0;
        int min = i;
        for (int j = i + 1; j < len; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        ArrayUtils.exchange(arr, min, i);
        ArrayUtils.print(arr, "选择排序第一轮排序=", ",");

        i = 1;
        min = i;
        for (int j = i + 1; j < len; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        ArrayUtils.exchange(arr, min, i);
        ArrayUtils.print(arr, "选择排序第二轮排序=", ",");

        i = 2;
        min = i;
        for (int j = i + 1; j < len; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        ArrayUtils.exchange(arr, min, i);
        ArrayUtils.print(arr, "选择排序第三轮排序=", ",");
    }
}
