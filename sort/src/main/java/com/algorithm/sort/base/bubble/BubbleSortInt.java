package com.algorithm.sort.base.bubble;

import com.algorithm.utils.ArrayUtils;
import com.algorithm.utils.sort.SortInt;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSortInt implements SortInt {

    @Override
    public void sort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) { // 每排序一趟，则必然后面有一个已经有序，可以缩小排序的范围
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.exchange(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(20, 1, 20);
        System.out.println(Arrays.toString(arr));
        new BubbleSortInt().sort(arr, 20);
        System.out.println(Arrays.toString(arr));
    }
}
