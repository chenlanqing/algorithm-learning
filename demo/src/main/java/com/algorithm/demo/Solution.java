package com.algorithm.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(coinChange(coins, amount));
    }

    static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        // 题目要求的最终结果是 dp(amount)
        return dp(coins, amount, memo);
    }

    // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
    static int dp(int[] coins, int amount, int[] memo) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -666){
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin, memo);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
            memo[amount] = res;
        }
        res = memo[amount];
        return res == -666 ? -1 : res;
    }

}