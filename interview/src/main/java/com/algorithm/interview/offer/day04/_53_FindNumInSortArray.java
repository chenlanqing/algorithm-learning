package com.algorithm.interview.offer.day04;

/**
 * 使用二分法找出左右边界
 *
 * @author QingFan 2021/10/8
 * @version 1.0.0
 */
public class _53_FindNumInSortArray {

    public static void main(String[] args) {
        _53_FindNumInSortArray d = new _53_FindNumInSortArray();
        int[] nums = {5, 7, 8, 8, 8, 10};
        System.out.println(d.search(nums, 8));
        System.out.println(d.search(nums, 6));
    }

    public int search(int[] nums, int len, int target) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * 统计一个数字在排序数组中出现的次数
     * <pre>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * </pre>
     * <pre>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     * </pre>
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        int from = findStart(nums, len, target);
        int end = findEnd(nums, len, target);
        if (from == -1 && end == -1) {
            return 0;
        }
        if (from == -1 || end == -1) {
            return 1;
        }
        return end - from + 1;
    }

    private int findStart(int[] nums, int len, int target) {
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private int findEnd(int[] nums, int len, int target) {
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                if (mid == len - 1 || nums[mid + 1] > target) {
                    return mid;
                }
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
