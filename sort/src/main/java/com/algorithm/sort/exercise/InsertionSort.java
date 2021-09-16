package com.algorithm.sort.exercise;

/**
 * @author QingFan 2021-08-26
 * @version 1.0.0
 */
public class InsertionSort implements IMutableSorter {

    @Override
    public void sort(int[] A) {
        for (int i = 1; i < A.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (A[j] < A[j - 1]) {
//                    Helper.swap(A, j, j-1);
//                } else {
//                    break;
//                }
//            }
            // 优化版本，将写
            int j;
            int temp = A[i];
            for (j = i; j > 0 && temp < A[j - 1]; j--) {
                A[j] = A[j - 1];
            }
            A[j] = temp;
        }
    }
}
