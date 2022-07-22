package com.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月22日 23:00
 */
public class _283_RemoveZero {

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int slow = 0;
		int fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != 0) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		for (; slow < nums.length; slow++) {
			nums[slow] = 0;
		}
	}

}
