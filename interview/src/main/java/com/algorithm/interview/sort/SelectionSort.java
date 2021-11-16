package com.algorithm.interview.sort;

import com.algorithm.common.utils.ArrayUtils;

/**
 * @author QingFan 2021/10/3
 * @version 1.0.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] A = ArrayUtils.generateRandomArray(10, 1, 100);
        ArrayUtils.print(A, 10);
        sort(A);
        ArrayUtils.print(A, 10);
    }

    public static void sort(int[] A) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && A[j] < A[j - 1]; j--) {
                ArrayUtils.exchange(A, j, j - 1);
            }
        }
    }
}
