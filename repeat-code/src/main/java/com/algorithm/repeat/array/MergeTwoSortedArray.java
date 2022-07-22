package com.algorithm.repeat.array;

import com.algorithm.common.utils.ArrayUtils;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月16日 19:15
 */
public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] num1 = {1, 3, 5, 7, 9};
		int[] num2 = {0, 2, 4, 6, 8};
		ArrayUtils.print(merge(num1, num2));
	}

	public static int[] merge(int[] num1, int[] num2) {
		if (num1 == null && num2 == null) {
			return null;
		}
		if (num1 == null) {
			return num2;
		}
		if (num2 == null) {
			return num1;
		}
		int m = num1.length;
		int n = num2.length;
		int idx1 = 0, idx2 = 0;
		int[] res = new int[m + n];
		int i = 0;
		while (idx1 < m && idx2 < n) {
			if (num1[idx1] < num2[idx2]) {
				res[i] = num1[idx1];
				idx1++;
			} else {
				res[i] = num2[idx2];
				idx2++;
			}
			i++;
		}

		while (idx1 < m) {
			res[i] = num1[idx1];
			i++;
			idx1++;
		}

		while (idx2 < n) {
			res[i] = num1[idx2];
			i++;
			idx2++;
		}
		return res;
	}

}
