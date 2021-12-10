package com.algorithm.sort.exercise;

import java.util.Arrays;

/**
 * @author QingFan 2021/10/3
 * @version 1.0.0
 */
public class MergeSort implements IMutableSorter {

    public static void main(String[] args) {
        int[] arr = {55, 54, 87, 73, 29, 47, 50, 89, 20, 78};
        new MergeSort().sort(arr);
    }

    @Override
    public void sort(int[] A) {
        mergeSort(A, 0, A.length);
    }

    private static void mergeSort(int[] A, int l, int r) {
        // 边界条件
        if (r - l <= 1) {
            return;
        }
        int mid = (l + r) / 2;
        /*
         * 数组元素：55 54 87 73 29 47 50 89 20 78，长度：10
         * mid = (5)
         */
        mergeSort(A, l, mid); // [0,5)
        mergeSort(A, mid, r); // [5,10)

        merge(A, l, mid, r);
    }

    private static void merge(int[] A, int l, int mid, int r) {
        int[] B = copy(A, l, mid + 1);
        int[] C = copy(A, mid, r + 1);
        // 超过一个元素，如果越界会补0；
//        int[] B = Arrays.copyOfRange(A, l, mid + 1);
//        int[] C = Arrays.copyOfRange(A, mid, r + 1);

        // 临时数组最后一个元素加入哨兵
        B[B.length - 1] = C[C.length - 1] = Integer.MAX_VALUE;
        int i = 0, j = 0;

        for (int k = l; k < r; k++) {
            if (B[i] > C[j]) {
                A[k] = C[j++];
            } else {
                A[k] = B[i++];
            }
        }
    }

    private static int[] copy(int[] A, int l, int r) {
        int[] res = new int[r - l];
        int j = 0;
        for (int i = l; i < r - 1; i++) {
            res[j++] = A[i];
        }
        return res;
    }
}
