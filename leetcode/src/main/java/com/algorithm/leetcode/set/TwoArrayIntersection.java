package com.algorithm.leetcode.set;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月13日 17:10
 */
public class TwoArrayIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
