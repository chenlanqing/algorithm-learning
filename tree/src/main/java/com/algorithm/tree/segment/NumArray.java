package com.algorithm.tree.segment;

import com.algorithm.common.utils.ArrayUtils;

public class NumArray {

    // 使用线段树的实现
    /*
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] arr = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(arr, Integer::sum);
        }
    }

    public int sumRange(int left, int right) {
        if (segmentTree == null) {
            return 0;
        }
        return segmentTree.query(left, right);
    }
     */

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        new NumArray(nums);
    }

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}