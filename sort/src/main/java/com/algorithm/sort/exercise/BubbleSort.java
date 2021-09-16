package com.algorithm.sort.exercise;

import static com.algorithm.sort.exercise.SortTests.genArray;

import com.algorithm.utils.ArrayUtils;
import org.junit.Test;

/**
 * 冒泡排序
 *
 * @author QingFan 2021-08-24
 * @version 1.0.0
 */
public class BubbleSort implements IMutableSorter {

    @Override
    public void sort(int[] A) {
        for (int i = A.length - 1; i > 0; i--) {
            // 22833 内层循环边界：数组长度
//            for (int j = 0; j < A.length - 1; j++) {
//                if (A[j] > A[j + 1]) {
//                    Helper.swap(A, j, j + 1);
//                }
//            }
            // 16149 内层循环边界
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    Helper.swap(A, j, j + 1);
                }
            }
        }
    }
}
