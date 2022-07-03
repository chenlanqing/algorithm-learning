package com.algorithm.leetcode.array;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author QingFan
 * @version 1.0.0
 * @leetcode https://leetcode.com/problems/sliding-window-maximum/Ï
 * @date 2022年07月02日 15:56
 */
public class _239_MaxSlidingWindow {

	public static void main(String[] args) {
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
	}

public static int[] maxSlidingWindow(int[] nums, int k) {
	int[] res = new int[nums.length - k + 1];
	int right = 0;
	int index = 0;
	LinkedList<Integer> list = new LinkedList<>();
	while (right < nums.length) {
		// list首位必须是窗口中最大的；
		while (!list.isEmpty() && nums[right] > list.peekLast()) {
			list.removeLast();
		}
		// 不断添加
		list.addLast(nums[right]);
		right++;
		// 窗口已经构造完成
		if (right >= k) {
			res[index++] = list.peekFirst();
			// 如果发现第一个已经在窗口外面了，就移除
			if (list.peekFirst() == nums[right -k]) {
				list.removeFirst();
			}
		}
	}
	return res;
}

	public static int[] maxSlidingWindow_1(int[] nums, int k) {
		int[] res = new int[nums.length - k + 1];
		LinkedList<Integer> list = new LinkedList<>();
		for (int right = 0; right < nums.length; right++) {
			while (!list.isEmpty() && nums[right] >= nums[list.peekLast()]) {
				list.removeLast();
			}
			list.addLast(right);
			int left = right - k + 1;
			if (list.peekFirst() < left) {
				list.removeFirst();
			}
			if (right + 1 >= k) {
				res[left] = nums[list.peekFirst()];
			}
		}

		return res;
	}

}
