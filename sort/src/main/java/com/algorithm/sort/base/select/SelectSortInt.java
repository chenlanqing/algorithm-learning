package com.algorithm.sort.base.select;

import com.algorithm.utils.ArrayUtils;
import com.algorithm.utils.sort.SortInt;

import java.util.Arrays;

/**
 * int类型数组选择排序:
 * 再要排序的一组数中,选出最小的数与第一个位置的数互换;然后在剩下的的数据中在找最小的数位置仅互换.
 * 第k趟比较需要进行的数组元素的两两比较的次数为n-k次，所以共需要的比较次数为n*(n-1) / 2，因此选择排序算法的时间复杂度为O(n^2);
 * 空间复杂度为 O(1)
 */
public class SelectSortInt implements SortInt {

    /**
     * 选择排序
     *
     * @param arr
     * @param n
     */
    @Override
    public void sort(int[] arr, int n) {
        if (arr == null || arr.length != n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        int[] arr = ArrayUtils.generateRandomArray(n,1,n);
        System.out.println(Arrays.toString(arr));
        ArrayUtils.testSort("Selection SortInt", new SelectSortInt(), arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
