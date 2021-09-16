package com.algorithm.interview.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * LeetCode Interview-283.Move Zeroes
 * <a href='https://leetcode.com/problems/move-zeroes/description/'>Move Zeros</a>
 *
 * @author BlueFish
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 6, 12, 0};
//        new MoveZeros().moveZeroes(nums);
        moveZeros(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeros(int[] nums) {
        int len = nums.length;
        int fast = 0, slow = 0;
        while (fast < len) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        for (; slow < len; slow++) {
            nums[slow] = 0;
        }
    }

    /**
     * 优化方案2：在判断非0时直接交换数据
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int k = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 判断是否都为非0元素
            if (nums[i] != 0) {
                if (i != k) {
                    nums[i] ^= nums[k];
                    nums[k] ^= nums[i];
                    nums[i] ^= nums[k];
                    k++;
                } else {
                    k++;
                }
            }

        }
    }

    /**
     * 优化方案1：取消空间申请，
     * 记录一个变量 k，保证 [0,k) 范围内为非 0 数据；
     * [k,nums.length) 为0
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int k = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < len; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 简单方案：时间复杂度 O(n)，空间复杂度O(n)
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }

        int size = list.size();
        for (int i = 0; i < size; i++) {
            nums[i] = list.get(i);
        }

        for (int i = size; i < len; i++) {
            nums[i] = 0;
        }
    }
}
