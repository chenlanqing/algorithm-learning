package com.algorithm.interview.array;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * @author QingFan 2021/10/23
 * @version 1.0.0
 */
public class FindDuplicateNum {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        final int len = nums.length;
        int start = 1, end = len - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int counter = 0;
            for (int num : nums) {
                if (num <= mid) {
                    counter++;
                }
            }
            if (counter > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


    public int findDuplicate1(int[] nums) {
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
