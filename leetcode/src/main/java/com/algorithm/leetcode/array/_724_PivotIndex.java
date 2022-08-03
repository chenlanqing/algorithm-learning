package com.algorithm.leetcode.array;

/**
 * https://leetcode.com/problems/find-pivot-index/
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2022年08月02日 21:34
 */
public class _724_PivotIndex {

	public static void main(String[] args) {
		int[] nums = {-1, -1, 0, 1, -1, -1};
		System.out.println(pivotIndex(nums));
	}


	public static int pivotIndex(int[] nums) {
		final int len = nums.length;
		int total = 0;
		for (int num : nums) {
			total += num;
		}
		int sum = 0;
		for (int i = 0; i < len; i++) {
			if (2 * sum + nums[i] == total) {
				return i;
			}
			sum += nums[i];
		}
		return -1;
	}

}
