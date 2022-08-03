package com.algorithm.leetcode.array;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月27日 22:16
 */
public class _209_MinSubArrayLen {

	public int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int sum = 0;
		int result = nums.length + 1;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (sum >= target) {
				result = Math.min(result, right - left + 1);
				sum -= nums[left];
				left++;

			}
		}
		return result == nums.length + 1 ? 0 : result;
	}

}
