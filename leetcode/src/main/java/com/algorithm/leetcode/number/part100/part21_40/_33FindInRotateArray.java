package com.algorithm.leetcode.number.part100.part21_40;

/**
 * leetcode: https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年12月27日 19:01
 */
public class _33FindInRotateArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 0, 1, 2};
        System.out.println(search(arr, 0));
    }

    public static int search(int[] nums, int target) {
        // {4, 5, 6, 7, 0, 1, 2}
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                }
                right = mid - 1;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
