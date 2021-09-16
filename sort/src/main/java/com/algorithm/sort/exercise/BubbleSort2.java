package com.algorithm.sort.exercise;

import com.algorithm.utils.ArrayUtils;

/**
 * 冒泡排序优化：对于近乎有序的数组
 *
 * @author QingFan 2021-08-26
 * @version 1.0.0
 */
public class BubbleSort2 implements IMutableSorter {

    @Override
    public void sort(int[] A) {
        boolean flag;
        for (int i = 0; i < A.length; i++) {
            // 每一轮循环将flag置为 true，然后在内层循环做比较，
            // 只要循环完一轮之后，没有做任何变更，可以认为数组已经排好序了
            flag = true;
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1] < A[j]) {
                    ArrayUtils.exchange(A, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
