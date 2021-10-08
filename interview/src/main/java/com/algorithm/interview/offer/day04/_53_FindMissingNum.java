package com.algorithm.interview.offer.day04;

/**
 * @author QingFan 2021/10/8
 * @version 1.0.0
 */
public class _53_FindMissingNum {

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * <pre>
     * 输入: [0,1,3]
     * 输出: 2
     * </pre>
     * <pre>
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     * </pre>
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findMissingNun(nums, nums.length);
    }

    private int findMissingNun(int[] nums, int n) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
