package com.algorithm.leetcode.array;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月22日 22:02
 */
public class _26_RemoveDuplicateEle {

	public static void main(String[] args) {
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != nums[slow]) {
				slow++;
				nums[slow] = nums[fast];
			}
			fast++;
		}
		return slow + 1;
	}

}
