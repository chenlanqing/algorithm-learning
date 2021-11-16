package com.algorithm.interview.sort;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月15日 18:56
 */
public class SelectionSort_2 {

    public int[] selectionSort(int[] A, int n) {
        if (A == null || n == 0) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
        return A;
    }
}
