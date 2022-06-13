package com.algorithm.interview.array;

import com.algorithm.common.utils.ArrayUtils;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年06月13日 21:48
 * @see com.algorithm.tree.heap.MaxHeap
 */
public class TopK {

	public static void main(String[] args) {
		int[] arr = {7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};
		ArrayUtils.print(arr, arr.length);
		System.out.println(findNumber(arr, 5));
	}

public static int findNumber(int[] arr, int k) {
	// 使用前k个元素构建小顶堆
	buildHeap(arr, k);
	for (int i = k; i < arr.length; i++) {
		if (arr[i] > arr[0]) {
			arr[0] = arr[i];
			shiftDown(arr, 0, k);
		}
	}
	return arr[0];
}

private static void buildHeap(int[] arr, int k) {
	for (int i = k / 2 - 1; i >= 0; i--) {
		shiftDown(arr, i, k);
	}
}

/**
 * 下沉调整
 *
 * @param arr 待调整的堆
 * @param index 需要下沉的节点
 * @param len 堆的有效大小
 */
private static void shiftDown(int[] arr, int index, int len) {
	int temp = arr[index];
	int leftChild = index * 2 + 1;
	while (leftChild < len) {
		// 如果有右孩子，且右孩子小于左孩子的值，则定位右孩子
		if (leftChild + 1 < len && arr[leftChild + 1] < arr[leftChild]) {
			leftChild++;
		}
		// 如果父节点小任何一个孩子的值，直接跳出
		if (temp <= arr[leftChild]) {
			break;
		}
		arr[index] = arr[leftChild];
		index = leftChild;
		leftChild = leftChild * 2 + 1;
	}
	arr[index] = temp;
}

}
