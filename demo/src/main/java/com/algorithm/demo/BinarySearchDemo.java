package com.algorithm.demo;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年07月04日 21:51
 */
public class BinarySearchDemo {

	public int find_1(int[] arr, int target) {
		int left = 0, right = arr.length - 1;// 定义target在左闭右闭的区间里，[left, right]
		while (left <= right) {// 当left==right，区间[left, right]依然有效，所以用 <=
			int mid = left + (right - left) / 2;
			if (arr[mid] > target) {
				right = mid - 1;// target 在左区间，所以[left, middle - 1]
			} else if (arr[mid] < target) {
				left = mid + 1;// target 在右区间，所以[middle + 1, right]
			} else {
				return mid;// 数组中找到目标值，直接返回下标
			}
		}
		return -1;
	}

	public int find(int[] arr, int target) {
		int left = 0, right = arr.length;// 定义target在左闭右闭的区间里，[left, right)
		while (left < right) {// 因为left == right的时候，在[left, right)是无效的空间，所以使用 <
			int mid = left + (right - left) / 2;
			if (arr[mid] > target) {
				right = mid;// target 在左区间，在[left, middle)中
			} else if (arr[mid] < target) {
				left = mid + 1;// target 在右区间，在[middle + 1, right)中
			} else {
				return mid;// 数组中找到目标值，直接返回下标
			}
		}
		return -1;
	}

}
