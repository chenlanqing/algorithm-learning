package com.algorithm.interview.offer.day05;

/**
 * @author QingFan 2021/10/9
 * @version 1.0.0
 */
public class _11_RotateMinNum {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，<br> 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5]
     * 的一个旋转，该数组的最小值为1；
     * <pre>
     * 输入：[3,4,5,1,2]
     * 输出：1
     *
     * 输入：[2,2,2,0,1]
     * 输出：0
     * </pre>
     */
    public int minArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                return findMin(nums, start, end);
            }
        }
        return nums[start];
    }

    private int findMin(int[] nums, int start, int end) {
        int result = nums[start];
        for (int i = start; i < end; i++) {
            if (nums[i] < result) {
                result = nums[i];
            }
        }
        return result;
    }

    /**
     * 下面使用直接遍历的方式
     */
    public int minArray1(int[] nums) {
        int result = nums[0];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < result) {
                result = nums[i];
            }
        }
        return result;
    }

}
