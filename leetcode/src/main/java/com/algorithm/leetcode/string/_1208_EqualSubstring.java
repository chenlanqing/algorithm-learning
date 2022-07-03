package com.algorithm.leetcode.string;

/**
 * @author QingFan
 * @version 1.0.0
 * @leetcode https://leetcode.com/problems/get-equal-substrings-within-budget/
 * @date 2022年07月02日 15:21
 */
public class _1208_EqualSubstring {

	public static void main(String[] args) {
		System.out.println(equalSubstring("abcd", "bcdf", 3));
		System.out.println(equalSubstring("abcd", "cdef", 3));
		System.out.println(equalSubstring("abcd", "acde", 0));
	}

	public static int equalSubstring(String s, String t, int maxCost) {
		int left = 0, right = 0;
		int sum = 0;
		int res = 0;
		while (right < s.length()) {
			sum += Math.abs(s.charAt(right) - t.charAt(right));
			right++;
			while (sum > maxCost) {
				sum -= Math.abs(s.charAt(left) - t.charAt(left));
				left++;
			}
			res = Math.max(res, right - left);
		}
		return res;
	}

}
