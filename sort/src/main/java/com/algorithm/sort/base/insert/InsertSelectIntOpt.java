package com.algorithm.sort.base.insert;

import com.algorithm.utils.ArrayUtils;
import com.algorithm.utils.sort.SortInt;

/**
 * 优化插入排序方法:在内存循环时,不直接交换数据,而是查找到当前元素应该放入的合适位置<br/>
 * 关于插入排序:在平均情况下以及最坏情况下，它的时间复杂度均为O(n^2)<br/>
 * 而在最好情况下（输入数组完全有序）,插入排序的时间复杂度能够提升至O(N).
 * 若我们待排序数组完全有序时,每一轮排序都只需比较一次，就能找到待排序元素在已排序数组中的合适的位置
 * 如果能确保数组部分有序或者完全有序,需要排序的时候可以选择插入排序
 */
public class InsertSelectIntOpt implements SortInt {

    @Override
    public void sort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void sort(int[] arr, int left, int right) {
        if (arr == null || left > right || left > arr.length || right > arr.length) {
            return;
        }
        for (int i = left+1; i <= right; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > left && arr[j - 1] > temp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int n = 20;
//        int[] select = ArrayUtils.generateNearySortArray(n, 1000);
//        int[] insert = Arrays.copyOf(select, n);
//        ArrayUtils.testSort("Selection SortInt", new SelectSortInt(), select, n);
//        ArrayUtils.testSort("Insert SortInt", new InsertSelectIntOpt(), insert, n);
        int[] arr = ArrayUtils.generateRandomArray(n, 0, 20);
        ArrayUtils.toString(arr, n);
        sort(arr, 10, 15);
        ArrayUtils.toString(arr, n);
    }
}
