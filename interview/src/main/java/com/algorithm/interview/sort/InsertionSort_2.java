package com.algorithm.interview.sort;

import com.algorithm.common.utils.ArrayUtils;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月15日 19:02
 */
public class InsertionSort_2 {

    public static void main(String[] args) {
        int[] arr = {32, 103, 24, 88, 95, 70, 97, 15, 102, 6, 79, 46, 51, 37, 93, 108, 9, 58, 53, 58, 79, 36, 58, 91,
                78, 58, 61, 81};
        ArrayUtils.print(arr, arr.length);
        int[] results = sort(arr, arr.length);
        ArrayUtils.print(results, results.length);
    }

    public static int[] sort(int[] A, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int temp = A[i];
            for (j = i; j > 0 && A[j - 1] > temp; j--) {
                A[j] = A[j - 1];
            }
            A[j] = temp;
        }
        return A;
    }

    public static int[] insertionSort(int[] A, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int temp = A[i];
            for (j = i; j > 0; j--) {
                if (A[j - 1] > temp) {
                    A[j] = A[j - 1];
                } else {
                    break;
                }
            }
            A[j] = temp;
        }
        return A;
    }


    // 插入排序，a表示数组，n表示数组大小
    public static int[] insertionSort1(int[] A, int n) {
        if (n <= 1) {
            return A;
        }

        for (int i = 1; i < n; ++i) {
            int value = A[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (A[j] > value) {
                    A[j + 1] = A[j];  // 数据移动
                } else {
                    break;
                }
            }
            A[j + 1] = value; // 插入数据
        }
        return A;
    }
}
