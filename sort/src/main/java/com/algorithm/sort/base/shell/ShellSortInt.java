package com.algorithm.sort.base.shell;

import com.algorithm.common.utils.ArrayUtils;
import com.algorithm.common.algorithm.sort.SortInt;

/**
 * 希尔排序是对插入排序的一种改进,它的核心思想是将待排序数组中任意间隔为h的元素都变为有序的,这样的数组叫做h有序数组.<br/>
 * 当h=1时，相应的h有序数组就是一个已经排序完毕的数组了<br/>
 * 希尔排序的大致过程如下：把待排序数组分割为若干子序列（一个子序列中的元素在原数组中间隔为h，即中间隔了h-1个元素），<br/>
 * 然后对每个子序列分别进行插入排序。然后再逐渐减小h，重复以上过程，直至h变为足够小时，再对整体进行一次插入排序。<br/>
 * 由于h足够小时，待排序数组的逆序数已经很小，所以再进行一次希尔排序是很快的
 */
public class ShellSortInt implements SortInt {
    @Override
    public void sort(int[] arr, int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    ArrayUtils.exchange(arr, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
