package com.algorithm.interview.sort;

import com.algorithm.common.utils.ArrayUtils;

/**
 * @author QingFan 2021/10/3
 * @version 1.0.0
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] A = ArrayUtils.generateRandomArray(10, 1, 100);
        ArrayUtils.print(A, 10);
        sort(A);
        ArrayUtils.print(A, 10);
    }

    public static void sort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            ArrayUtils.exchange(A, i, min);
        }
    }
}
