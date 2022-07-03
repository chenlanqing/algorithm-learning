package com.algorithm.leetcode.string;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月02日 16:40
 */
public class _1456_MaxVowels {

	public int maxVowels(String s, int k) {
		int right = 0;
		int max = 0;
		int sum = 0;

		while (right < s.length()) {
			sum += isVowel(s.charAt(right));
			right++;
			if (right >= k) {
				max = Math.max(sum, max);
				sum -= isVowel(s.charAt(right - k));
			}
		}
		return max;
	}

	public int isVowel(char s) {
		return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u' ? 1 : 0;
	}

}
