package com.algorithm.dp.lis;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 最长递增子序列
 *
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Leetcode-300</a>
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2023年03月19日 12:59
 */
public class LongIncreasingSub {


    public static void main(String[] args) {
        int[] nums = IntStream.of(6, 3, 5, 10, 11, 2, 9, 14, 13, 7, 4, 8, 12).toArray();
//        int[] nums = IntStream.rangeClosed(1, 15).toArray();
        System.out.println(new LongIncreasingSub().binarySearch(nums));
        System.out.println(new LongIncreasingSub().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

    public int binarySearch(int[] nums) {
        int[] top = new int[nums.length];
        int pile = 0;// 牌堆数初始化为 0
        for (int i = 0; i < nums.length; i++) {
            int poker = nums[i];// 牌堆数初始化为 0
            int left = 0, right = pile;
            /***** 搜索左侧边界的二分查找 *****/
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/
            if (left == pile) {
                pile++;// 没找到合适的牌堆，新建一堆
            }
            top[left] = poker;// 没找到合适的牌堆，新建一堆
        }
        System.out.println(Arrays.toString(top));
        return pile;// 牌堆数就是 LIS 长度
    }

}
