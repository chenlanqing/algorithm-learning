package com.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年08月10日 19:56
 */
public class _59_SpiralMatrix2 {

	public static void main(String[] args) {
		final int[][] matrix = generateMatrix(5);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public static int[][] generateMatrix(int n) {
		int x = 0, y = 0;// 定义每循环一个圈的起始位置
		int loop = 0/*控制循环次数*/, count = 1;// 定义填充数字
		int i, j; //每次循环的开始点(i, j)
		int[][] res = new int[n][n];
		while (loop++ < n / 2) {
			// 模拟上侧从左到右
			for (j = y; j < n - loop; j++) {
				res[x][j] = count++;
			}
			// 模拟右侧从上到下
			for (i = x; i < n - loop; i++) {
				res[i][j] = count++;
			}
			// 模拟下侧从右到左
			for (; j >= loop; j--) {
				res[i][j] = count++;
			}
			// 模拟左侧从下到上
			for (; i >= loop; i--) {
				res[i][j] = count++;
			}
			// 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
			x++;
			y++;
		}
		// 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
		if (n % 2 != 0) {
			res[x][y] = count;
		}
		return res;
	}

}
