package com.algorithm.interview.sort;

import com.algorithm.common.utils.ArrayUtils;
import java.util.Arrays;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月16日 10:48
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSortDerivation();
        System.out.println(Arrays.toString(shellSort2(arr, 10)));
    }

    public static int[] shellSort2(int[] A, int n) {
        System.out.println(("原始数组=") + Arrays.toString(A));
        int count = 0;
        for (int gap = n / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < A.length; i++) {
                int j = i;
                int temp = A[j];
                if (A[j] < A[j - gap]) {
                    while (j - gap >= 0 && temp < A[j - gap]) {
                        A[j] = A[j - gap];
                        j -= gap;
                    }
                    A[j] = temp;
                }
            }
            System.out.println(("希尔排序第" + (++count) + "轮排序=") + Arrays.toString(A));
        }
        return A;
    }

    public static int[] shellSort(int[] A, int n) {
        // 通过下面的 shellSortDerivation 可以找出规律
        int temp;
//        int count = 0;
        for (int gap = n / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < A.length; i++) {
                // 遍历各组中所有的元素(共gap组), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (A[j] > A[j + gap]) {
                        temp = A[j];
                        A[j] = A[j + gap];
                        A[j + gap] = temp;
                    }
                }
            }
//            System.out.println(("希尔排序第" + (++count) + "轮排序=") + Arrays.toString(A));
        }
        return A;
    }

    /**
     * 希尔排序推导过程
     */
    public static void shellSortDerivation() {
        // 假设有如下数组
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int temp;
        // >>>> 第一轮排序
        // 步长 = arr.length / 2，即 10/2 = 5；
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组中所有的元素(共5组，每组有2个元素), 步长5
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        ArrayUtils.print(arr, "希尔排序第1轮排序=");

        // >>>> 第二轮排序
        // 步长 = arr.length / 2 / 2，即 10/2/2 = 2；
        for (int i = 2; i < arr.length; i++) {
            // 遍历各组中所有的元素(共2组，每组有5个元素), 步长2
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        ArrayUtils.print(arr, "希尔排序第2轮排序=");

        // >>>> 第三轮排序
        // 步长 = arr.length / 2 / 2 / 2，即 10/2/2/2 = 1；
        for (int i = 1; i < arr.length; i++) {
            // 遍历各组中所有的元素(共1组，每组有10个元素), 步长1
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        ArrayUtils.print(arr, "希尔排序第3轮排序=");
    }
}
