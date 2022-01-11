package com.algorithm.tree.interview;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月11日 13:42
 */
public class NumsTree {

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
