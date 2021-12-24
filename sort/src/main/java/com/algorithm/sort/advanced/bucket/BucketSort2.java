package com.algorithm.sort.advanced.bucket;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年12月11日 12:54
 */
public class BucketSort2 {

    public static void main(String[] args) {
        int[] arr = {53, 88888, 3, 542, 5555, 748, 14, 214};
        bucketSort(arr);
    }

    public static void bucketSort(int[] A) {
        int max = A[0];
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        // 找到数组中最大的数的长度
        int maxLength = (max + "").length();
        // 获取需要分的桶
        int k = Integer.parseInt(String.format("1%0" + maxLength + "d", 0));
        bucketSort(A, k);
    }

    public static void bucketSort(int[] A, int k) {
        final ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        final ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new LinkedList<>());
        }
        for (var item : A) {
            buckets.get(item % k).add(item);
        }

        for (var bucket : buckets) {
            list.addAll(bucket);
        }
        System.out.println(list);
    }
}
