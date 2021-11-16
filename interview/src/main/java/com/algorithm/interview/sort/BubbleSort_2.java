package com.algorithm.interview.sort;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月15日 18:51
 */
public class BubbleSort_2 {

    public int[] bubbleSort(int[] A, int n) {
        if (A == null || n == 0) {
            return null;
        }
        boolean flag;
        for (int i = 0; i < n; i++) {
            flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return A;
    }
}
