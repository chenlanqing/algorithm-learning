package com.algorithm.interview.array;

/**
 * @author QingFan 2021/9/30
 * @version 1.0.0
 */
public class FindLossNumber {

    public int missingNumber(int[] nums) {
        // left 指向当前区间的最左边位置，所以初始化为 0
        int left = 0;
        // right 指向当前区间的最右边位置，所以初始化为 nums.length - 1
        int right = nums.length - 1;
        // 循环进行二分查找，直到左端点位置超过了右端点
        while (left <= right) {
            // 计算当前区间的中间位置，向下取整
            int mid = (left + right) / 2;
            // 如果中间位置的元素值等于当前索引的值
            // 那么说明从 left 到 mid 的这些元素都在正确的位置上
            // 即从 left 到 mid 的这些数字都在数组中，没有发生缺失
            // 所以需要在 mid + 1 到 right 这个区间去查找缺失的数字
            if (nums[mid] == mid) {
                // 缩小范围为 mid + 1 到 right
                // 当前区间的左侧为 left = mid + 1，右侧 right
                left = mid + 1;
                // 否则，说明从 left 到 mid 的这些元素，有元素不在正确的位置上
                // 即从 left 到 mid 的这些数字有数字发生缺失
                // 所以需要在 left 到 mid - 1 这个区间去查找缺失的数字
            } else {

                // 所以缩小范围为 left 到 mid - 1
                // 当前区间的左侧为 left，右侧 right = mid - 1
                right = mid - 1;

            }
        }
        // 由于只有一个数字缺失，所以找到的时候，left 指向的那个数字就是，使得后面所有数字与索引不一一对应时的第一个数字
        // 返回就行
        return left;
    }
}
