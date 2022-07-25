package com.algorithm.leetcode.array;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月23日 17:57
 */
public class _287_FindDuplicate {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 4, 5};
		System.out.println(findDuplicateInSortedArray(nums));
	}

	/**
	 * 通过数组环实现
	 */
	public int findDuplicateWithCycle(int[] nums) {
		if (nums == null || nums.length < 2) {
			return -1;
		}
		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (slow != fast) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}

	public int findDuplicate(int[] nums) {
		int start = 1, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (isValid(nums, mid)) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (isValid(nums, start)) {
			return end;
		}
		return start;
	}

	public boolean isValid(int[] nums, int n) {
		int count = 0;
		for (int i : nums) {
			if (n >= i) {
				count++;
			}
		}
		return count <= n;
	}

	/**
	 * 在有序数组中找到唯一的重复数字
	 */
	public static int findDuplicateInSortedArray(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		int ans = -1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if ((m - 1 >= 0 && nums[m - 1] == nums[m]) || (m + 1 < nums.length && nums[m + 1] == nums[m])) {
				ans = m;
				break;
			}
			if (m - l == nums[m] - nums[l]) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return ans == -1 ? 0 : nums[ans];
	}

}
