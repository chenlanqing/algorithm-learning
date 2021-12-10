package com.algorithm.sort.exercise;

import com.algorithm.common.utils.ArrayUtils;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年12月09日 10:45
 */
public class QuickSort {

    public static void main(String[] args) {
//        final int[] array = ArrayUtils.generateRandomArray(10, 0, 20);
        final int[] array = {14, 4, 17, 6, 9, 15, 2, 19, 4, 5};
        ArrayUtils.print(array, array.length);
        new QuickSort().quickSort(array, array.length);
        ArrayUtils.print(array, array.length);
    }

    public int[] quickSort(int[] A, int n) {
        if (A == null || A.length == 0) {
            return null;
        }
        quickSort(A, 0, A.length - 1);
        return A;
    }

    public void quickSort(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }

        int partition = partition(A, left, right);
        quickSort(A, left, partition - 1);
        quickSort(A, partition + 1, right);
    }

    private int partition(int[] A, int l, int r) {
        int temp = A[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (temp > A[i]) {
                exchange(A, j + 1, i);
                j++;
            }
        }
        exchange(A, j, l);
        return j;
    }

    private void exchange(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
