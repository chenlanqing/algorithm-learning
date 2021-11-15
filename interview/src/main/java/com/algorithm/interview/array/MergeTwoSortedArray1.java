package com.algorithm.interview.array;

import com.algorithm.common.utils.ArrayUtils;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * @author QingFan 2021/9/30
 * @version 1.0.0
 */
public class MergeTwoSortedArray1 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return;
        }
        int[] res = new int[m + n];

        int idx1 = 0;
        int idx2 = 0;
        int i = 0;
        while (idx1 < m && idx2 < n) {
            if (nums1[idx1] < nums2[idx2]) {
                res[i] = nums1[idx1];
                idx1++;
            } else {
                res[i] = nums2[idx2];
                idx2++;
            }
            i++;
        }

        while (idx1 < m) {
            res[i] = nums1[idx1];
            idx1++;
            i++;
        }

        while (idx2 < n) {
            res[i] = nums2[idx2];
            idx2++;
            i++;
        }
        for (int j = 0; j < m + n; j++) {
            nums1[j] = res[j];
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedArray1 d = new MergeTwoSortedArray1();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        d.merge(num1, 3, num2, 3);
        ArrayUtils.print(num1, 0);
    }
}
