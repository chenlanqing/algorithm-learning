package com.algorithm.leetcode.part400.part341_360;

import java.util.Arrays;

/**
 * @author bluefish 2019-04-08
 * @version 1.0.0
 */
public class _343IntegerBreak {

    public static void main(String[] args) {
        Recursive r = new Recursive();
        System.out.println(r.integerBreak(10));

        Dynamic d = new Dynamic();
        System.out.println(d.integerBreak(10));
    }

    /**
     * 动态规划
     */
    private static class Dynamic {
        private int[] memo;

        public int integerBreak(int n) {
            assert n >= 2;

            // memo[i]表示将数字i分割（至少分割成两不部分）后得到的最大乘积
            memo = new int[n + 1];

            Arrays.fill(memo, -1);

            memo[1] = 1;
            for (int i = 2; i <= n; i++) {
                // 求解memo[i]
                for (int j = 1; j <= i - 1; j++) {
                    // j + (i-j)
                    memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
                }
            }

            return memo[n];
        }
    }

    /**
     * 递归实现
     */
    private static class Recursive {
        private int[] memo;

        public int integerBreak(int n) {
            assert n >= 2;

            memo = new int[n + 1];

            Arrays.fill(memo, -1);

            return breakInteger(n);
        }

        private int breakInteger(int n) {
            if (n == 1) {
                return 1;
            }

            int res = -1;
            if (memo[n] != -1) {
                return memo[n];
            }

            for (int i = 1; i <= n - 1; i++) {
                res = max3(res, i * (n - i), i * breakInteger(n - i));
            }
            memo[n] = res;
            return memo[n];
        }
    }

    private static int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
