package com.algorithm.sort.base.insert;

import com.algorithm.utils.ArrayUtils;
import com.algorithm.utils.sort.SortInt;
import com.algorithm.sort.base.select.SelectSortInt;

import java.util.Arrays;

/**
 * 插入排序:假设待排序数组为a，我们从a[1]开始，让a[1]与a[0]比较，若a[1]较小，则让a[1]和a[0]交换位置，此时a[0]和a[1]就相当于已经放入左手中的牌<br/>
 * 然后我们再让a[2]与a[1]、a[0]比较，并为它找到一个合适的位置，以此类推，直到为数组的最后一个元素也找到了合适的位置
 */
public class InsertionSortInt implements SortInt {

    @Override
    public void sort(int[] arr, int n) {
        // 从第二个元素开始比较,默认认为第一个元素是有序,
        for (int i = 1; i < n; i++) {
            // 查找到 arr[i]元素的合适位置
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                arr[j] ^= arr[j-1];
                arr[j-1] ^= arr[j];
                arr[j] ^= arr[j-1];
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        int[] select = ArrayUtils.generateRandomArray(n,1,n);
        int[] insert = Arrays.copyOf(select, n);
        ArrayUtils.testSort("Selection SortInt", new SelectSortInt(), select, n);
        ArrayUtils.testSort("Insert SortInt", new InsertionSortInt(), insert, n);
    }
}
