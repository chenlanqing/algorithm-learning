package com.algorithm.datastructure.array;

import com.algorithm.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bluefish 2019-07-01
 * @version 1.0.0
 */
public class TwoNumHash {

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 5, 6, 11, 25, 11, 10, 4};
        ArrayUtils.print(arr, arr.length);

        int[] ints = twoSum(arr, 15);
        ArrayUtils.print(ints, ints.length);

        List<int[]> list = allTwoSum(arr, 15);
        for (int[] a : list) {
            ArrayUtils.print(a, a.length);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static List<int[]> allTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result.add(new int[]{map.get(complement), i});
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
