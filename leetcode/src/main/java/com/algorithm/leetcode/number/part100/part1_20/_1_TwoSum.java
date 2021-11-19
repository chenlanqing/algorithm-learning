package com.algorithm.leetcode.number.part100.part1_20;

import java.util.HashMap;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月16日 09:40
 */
public class _1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != i) {
                return new int[]{i, map.get(remain)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
