package com.algorithm.leetcode.array;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月22日 21:09
 */
public class _34_RemoveElements {

	public static void main(String[] args) {
		int[] nums = {3, 2, 2, 3};
		System.out.println(removeElement(nums, 3));
	}

	public static int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != val) {
				nums[slow] = nums[fast];
				slow++;
			}
			fast++;
		}
		return slow;
	}

}
