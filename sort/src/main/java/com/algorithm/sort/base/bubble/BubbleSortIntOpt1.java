package com.algorithm.sort.base.bubble;

import com.algorithm.common.utils.ArrayUtils;
import com.algorithm.common.algorithm.sort.SortInt;

/**
 * 冒泡排序优化方案1:加一个标记来判断每一趟排序时是否交换过数据，如果哪一趟排序没有交换数据，则这时就已经有序了
 */
public class BubbleSortIntOpt1 implements SortInt {

    @Override
    public void sort(int[] arr, int n) {
        boolean flag;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.exchange(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }
}
