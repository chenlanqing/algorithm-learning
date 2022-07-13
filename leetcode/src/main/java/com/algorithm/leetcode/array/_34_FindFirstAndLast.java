package com.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月11日 20:14
 */
public class _34_FindFirstAndLast {

	public static void main(String[] args) {
		final _34_FindFirstAndLast last = new _34_FindFirstAndLast();
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
		int left = findLeft(nums, target);
		int right = findRight(nums, target);
		if (left == -1 && right == -1) {
			return new int[]{-1, -1};
		}
		if (left == -1) {
			return new int[]{right, right};
		}
		if (right == -1) {
			return new int[]{left, left};
		}
		return new int[]{left, right};
	}

	private int findLeft(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				if (mid == 0 || nums[mid - 1] < target) {
					return mid;
				}
				right = mid - 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	private int findRight(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				if (mid == nums.length - 1 || nums[mid + 1] > target) {
					return mid;
				}
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
