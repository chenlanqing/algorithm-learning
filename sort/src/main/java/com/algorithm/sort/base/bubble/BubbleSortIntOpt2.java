package com.algorithm.sort.base.bubble;

import com.algorithm.common.utils.ArrayUtils;
import com.algorithm.common.algorithm.sort.SortInt;

/**
 * 冒泡排序优化方案2:
 */
public class BubbleSortIntOpt2 implements SortInt {

    @Override
    public void sort(int[] arr, int n) {
        boolean flag = true;
        int k = n - 1;
        int m = 0;
        for (int i = 0; i < n - 1; i++) {
            flag = true;
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j+1]){
                    ArrayUtils.exchange(arr, j, j +1);
                    m = j;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
            k = m;
        }
    }
}

