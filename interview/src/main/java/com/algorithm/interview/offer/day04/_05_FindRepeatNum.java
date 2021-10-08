package com.algorithm.interview.offer.day04;

/**
 * @author QingFan 2021/10/8
 * @version 1.0.0
 */
public class _05_FindRepeatNum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] repeat = new int[n];
        for (int num : nums) {
            repeat[num]++;
            if (repeat[num] > 1) {
                return num;
            }
        }
//        for (int i = 0; i < n; i++) {
//            if (repeat[i] > 1) {
//                return i;
//            }
//        }
        return 0;
    }
}
