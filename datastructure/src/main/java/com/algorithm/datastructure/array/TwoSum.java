package com.algorithm.datastructure.array;

/**
 * @author bluefish 2019-04-04
 * @version 1.0.0
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
