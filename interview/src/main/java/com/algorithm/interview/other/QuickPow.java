package com.algorithm.interview.other;

/**
 * 快速幂思想：实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 *
 * https://leetcode.com/problems/powx-n/
 *
 * @author QingFan 2021/9/15
 * @version 1.0.0
 */
public class QuickPow {

	public static void main(String[] args) {
		System.out.println(myPow(5, 10));
		System.out.println(myPow1(5, 10));
		System.out.println(binpow(5,10));
	}

	public static long binpow(long a, long b) {
		if (b == 0) {
			return 1;
		}
		long res = binpow(a, b / 2);
		if (b % 2 != 0) {
			return res * res * a;
		} else {
			return res * res;
		}
	}

	public static double myPow(double x, int n) {
		long N = n;
		// 从条件里面可以看出来指数会存在负数的情况
		return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
	}

	public static double quickMul(double x, long N) {
		if (N == 0) {
			return 1.0;
		}
		double y = quickMul(x, N / 2);
		// 进行奇偶判断奇数要乘上x
		return N % 2 == 0 ? y * y : y * y * x;
	}

	public static double myPow1(double x, int n) {
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		double pow = 1;
		while (n != 0) {
			// n & 1 是否为0是判断奇偶数的
			if ((n & 1) != 0) {
				pow *= x;
			}
			x *= x;
			n >>>= 1;

		}
		return pow;
	}
}
