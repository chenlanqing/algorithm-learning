package com.algorithm.leetcode.array;


/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月10日 17:42
 */
public class _35_SearchInsertPosition {

	public static void main(String[] args) {
		final _35_SearchInsertPosition position = new _35_SearchInsertPosition();
		int[] nums = {1, 3, 5, 6};
		System.out.println(position.searchInsert1(nums, 2));
		System.out.println(position.searchInsert(nums, 2));
		System.out.println(position.searchInsert(nums, 7));

	}

	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = mid - 1;// target 在左区间，所以[right, mid - 1]
			} else if (nums[mid] < target) {
				left = mid + 1;// target 在左区间，所以[mid + 1, left]
			} else {
				return mid;
			}
		}
		// 目标值在数组所有元素之前、目标值插入数组中、目标值在数组所有元素之后
		return right + 1;
	}

	public int searchInsert1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			// 分别处理如下三种情况
			// 目标值在数组所有元素之前
			// 目标值等于数组中某一个元素
			// 目标值插入数组中的位置
			if (nums[i] >= target) {
				// 一旦发现大于或者等于target的num[i]，那么i就是我们要的结果
				return i;
			}
		}
		// 目标值在数组所有元素之后的情况
		return nums.length;
	}


}
