package com.algorithm.sort.exercise;

/**
 * @author QingFan 2021-08-24
 * @version 1.0.0
 */
public class SelectionSort implements IMutableSorter {

    @Override
    public void sort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int min = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            Helper.swap(A, min, i);
        }
    }
}
