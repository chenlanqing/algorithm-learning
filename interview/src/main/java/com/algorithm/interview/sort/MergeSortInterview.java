package com.algorithm.interview.sort;

import com.algorithm.common.utils.ArrayUtils;

/**
 * @author QingFan 2021/10/3
 * @version 1.0.0
 */
public class MergeSortInterview {

    public static void main(String[] args) {
        int[] A = ArrayUtils.generateRandomArray(10, 1, 100);
        int[] B = ArrayUtils.copy(A, 10);
        ArrayUtils.print(A, 10);
        sort(A, 0, A.length);
        ArrayUtils.print(A, 10);

        System.out.println("--------");

        ArrayUtils.print(B, 10);
        SelectSort.sort(B);
        ArrayUtils.print(B, 10);
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length);
        return nums;
    }

    private static void sort(int[] A, int l, int r) {
        // 边界条件
        if (r - l <= 1) {
            return;
        }
        int mid = (l + r) / 2;
        /*
         * 数组元素：55 54 87 73 29 47 50 89 20 78，长度：10
         * mid = (5)
         */
        sort(A, l, mid); // [0,5)
        sort(A, mid, r); // [5,10)

        merge(A, l, mid, r);
    }

    private static void merge(int[] A, int l, int mid, int r) {
        int[] B = copy(A, l, mid + 1);
        int[] C = copy(A, mid, r + 1);
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
