package com.algorithm.interview.array;

import java.util.Arrays;

/**
 * <a href=https://leetcode.com/problems/remove-element/description/>remove-element</a>
 * Given nums = [3,2,2,3], value = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        int element = removeElement(array, 5);

    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int fast = 0, slow = 0;
        while (fast < len) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
