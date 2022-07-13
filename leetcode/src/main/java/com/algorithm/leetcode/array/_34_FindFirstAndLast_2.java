package com.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月11日 20:14
 */
public class _34_FindFirstAndLast_2 {

	public static void main(String[] args) {
		final _34_FindFirstAndLast_2 last = new _34_FindFirstAndLast_2();
		int[] nums = {5, 7, 7, 8, 8, 10};
		System.out.println(Arrays.toString(last.searchRange(nums, 8)));
		System.out.println(Arrays.toString(last.searchRange(nums, 6)));
		System.out.println(Arrays.toString(last.searchRange(nums, 10)));
		System.out.println(Arrays.toString(last.searchRange(nums, 5)));
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[]{-1, -1};
		}
		// 二分查找找到其中一个
		int index = findTarget(nums, target);
		if (index == -1) {
			return new int[]{-1, -1};
		}
		int left = index;
		int right = index;
		// 向左滑动，找左边界，需要注意边界问题
		while (left - 1 >= 0 && nums[left - 1] == target) {
			left--;
		}
		// 向右滑动，找右边界，同样需要注意边界问题
		while (right + 1 <= nums.length - 1 && nums[right + 1] == target) {
			right++;
		}
		return new int[]{left, right};
	}

	public int findTarget(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
