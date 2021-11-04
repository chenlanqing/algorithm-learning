package com.algorithm.datastructure.array;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * @author QingFan 2021/10/23
 * @version 1.0.0
 */
public class FindDuplicateNum {

    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (isValid(nums, start)) {
            return end;
        }
        return start;
    }

    public boolean isValid(int[] nums, int n) {
        int count = 0;
        for (int i : nums) {
            if (n >= i) {
                count++;
            }
        }
        return count <= n;
    }
}
