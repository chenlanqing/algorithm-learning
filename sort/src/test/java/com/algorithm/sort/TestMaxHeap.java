package com.algorithm.sort;

import com.algorithm.sort.advanced.heap.MaxHeap;

/**
 * Created by BlueFish on 2017/5/6.
 */
public class TestMaxHeap {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(100);
        for (int i = 0; i < 15; i++) {
            int n = (int)(Math.random() * 100);
            heap.insert(n);
        }
        System.out.println(heap.size());
        while (!heap.isEmpty()){
            System.out.print(heap.extractMax() + " ");
        }
    }
}
