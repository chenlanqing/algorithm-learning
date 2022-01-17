package com.algorithm.tree.heap;

import com.algorithm.common.utils.ArrayUtils;
import java.util.PriorityQueue;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2022年01月14日 14:00
 */
public class TestMaxHeap {

    public static void main(String[] args) {
//        MaxHeap<Integer> heap = new MaxHeap<>();
//        int[] arr = {28, 16, 22, 13, 19, 62, 41, 30, 17, 15};
//        for (int num : arr) {
//            heap.add(num);
//        }
        Integer[] arr = {28, 16, 22, 13, 19, 62, 41, 30, 17, 15};
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
        System.out.println(heap);
        heap.add(53);
        System.out.println(heap);
        heap.replace(43);
        System.out.println(heap);
        int[] res = new int[arr.length + 1];
        int i = 0;
        while (!heap.isEmpty()) {
            res[i++] = heap.extractMax();
        }
        ArrayUtils.print(res, res.length);

    }
}
