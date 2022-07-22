package com.algorithm.interview.array;

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

	/**
	 * 另一种实现
	 */
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		if (nums1.length == 0 & nums2.length == 0) {
			return 0;
		}
		int[] finalArr = new int[nums1.length + nums2.length];
		int n1 = 0;
		int n2 = 0;
		for (int i = 0; i < finalArr.length; i++) {
			if (n2 >= nums2.length || (n1 < nums1.length && nums1[n1] <= nums2[n2])) {
				finalArr[i] = nums1[n1];
				n1++;
			} else {
				finalArr[i] = nums2[n2];
				n2++;
			}
		}
		return finalArr.length % 2 == 1 ? finalArr[finalArr.length / 2]
				: (finalArr[(finalArr.length / 2) - 1] + finalArr[(finalArr.length / 2)]) / 2.0;

	}

	public static void main(String[] args) {
		MergeTwoSortedArray mt = new MergeTwoSortedArray();
		int[] nums1 = {1, 2, 3, 4, 5};
		int[] nums2 = {2, 4, 6};
		System.out.println(mt.findMedianSortedArrays1(nums1, nums2));
	}
}
