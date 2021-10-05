package com.algorithm.interview.sort;

import com.algorithm.common.utils.ArrayUtils;

/**
 * @author QingFan 2021/10/3
 * @version 1.0.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] A = ArrayUtils.generateRandomArray(10, 1, 100);
        ArrayUtils.print(A, 10);
        sort(A);
        ArrayUtils.print(A, 10);
    }

    public static void sort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    ArrayUtils.exchange(A, j, j + 1);
                }
            }
        }
    }
}
