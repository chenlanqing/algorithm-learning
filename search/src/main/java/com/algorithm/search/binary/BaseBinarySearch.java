package com.algorithm.search.binary;

/**
 * 基础二分查找
 */
public class BaseBinarySearch {

    /**
     * 非递归二分查找
     *
     * @param arr  数组
     * @param data 查找的元素
     * @return
     */
    public static int binarySearch(int[] arr, int data) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        // 从[l...r]中查找
        int l = 0, r = len - 1;
        while (l <= r) {
//            int mid = (l + r) / 2;// 这里,如果在极限情况下,可能出现int溢出
//            int mid = l + (r - l) / 2;
            int mid = l + ((r - l) >>> 1);
            if (arr[mid] == data) {
                return mid;
            }
            if (arr[mid] > data) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] arr, int l, int r, int data) {
        if (arr == null || arr.length == 0 || l > r) {
            return -1;
        }
        // 从[l...r]中查找
        int mid = l + (r - l) / 2;
        if (arr[mid] == data) {
            return mid;
        } else if (arr[mid] > data) {
            return recursiveBinarySearch(arr, l, mid - 1, data);
        } else {
            return recursiveBinarySearch(arr, mid + 1, r, data);

        }
    }
}
