package com.algorithm.datastructure.array;

/**
 * @author QingFan 2021/9/30
 * @version 1.0.0
 */
public class MergeTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0D;
        }
        if (nums1 == null || nums1.length == 0) {
            return findMedianSortedArrays(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return findMedianSortedArrays(nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1 + len2];

        int idx1 = 0;
        int idx2 = 0;
        int i = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2]) {
                res[i] = nums1[idx1];
                idx1++;
            } else {
                res[i] = nums2[idx2];
                idx2++;
            }
            i++;
        }

        while (idx1 < len1) {
            res[i] = nums1[idx1];
            idx1++;
            i++;
        }

        while (idx2 < len2) {
            res[i] = nums2[idx2];
            idx2++;
            i++;
        }
        return findMedianSortedArrays(res);
    }

    public double findMedianSortedArrays(int[] num) {
        int len = num.length;
        int mid = len / 2;
        if (len % 2 != 0) {
            return num[mid];
        } else {
            return (num[mid - 1] + num[mid]) / 2.0;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedArray mt = new MergeTwoSortedArray();
        int[] num = {1, 2, 3, 4, 5};
        int[] nums1 = {2};
        int[] nums2 = {};
        System.out.println(mt.findMedianSortedArrays(nums1, nums2));
    }
}
