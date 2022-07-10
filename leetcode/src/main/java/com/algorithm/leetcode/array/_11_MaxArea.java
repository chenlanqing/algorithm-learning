package com.algorithm.leetcode.array;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月04日 20:10
 */
public class _11_MaxArea {

	public int maxArea(int[] height) {
		int res = 0;
		int left = 0, right = height.length - 1;

		while (left < right) {
			int width = right - left;
			int h = Math.min(height[left], height[right]);

			int area = width * h;

			if (area >= res) {
				res = area;
			}

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return res;
	}

}
