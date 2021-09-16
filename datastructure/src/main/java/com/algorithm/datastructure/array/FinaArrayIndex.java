package com.algorithm.datastructure.array;

/**
 * 求数组中比左边元素都大同时比右边元素都小的元素，返回这些元素的索引
 *
 * 要求时间复杂度
 * <pre>
 * 输入：[2, 3, 1, 8, 9, 20, 12]
 * 输出：3, 4
 * 解释：数组中 8, 9 满足题目要求，他们的索引分别是 3、4
 * </pre>
 *
 * @author QingFan 2021/9/6
 * @version 1.0.0
 */
public class FinaArrayIndex {

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 8, 9, 20, 12};
        find(A);
    }

    public static void find(int[] A) {
        int n = A.length;
        int[] left_max = new int[n];
        int[] right_min = new int[n];

        for (int i = 0; i < n; i++) {
            left_max[i] = Integer.MIN_VALUE;
            right_min[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], A[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right_min[i] = Math.min(right_min[i + 1], A[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            if (left_max[i] < A[i] && A[i] < right_min[i]) {
                System.out.println(i);
            }
        }
    }
}
