package com.algorithm.leetcode.part100.part41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整型数组，其中的每一个元素都各部相同，返回这些元素的所有排列可能；
 *
 * @author bluefish 2019-04-06
 * @version 1.0.0
 */
public class _46Permutations {

    public static void main(String[] args) {
        _46Permutations s = new _46Permutations();
        int nums[] = {1, 2, 3};
        System.out.println(s.permute(nums));
    }

//    public List<List<Integer>> permute(int[] nums) {
//
//
//        return null;
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
