package com.algorithm.datastructure;

import com.algorithm.common.utils.ArrayUtils;
import com.algorithm.datastructure.array.DynamicArray;
import com.algorithm.datastructure.stack.ArrayStack;
import java.util.Arrays;

/**
 * @author bluefish 2019-04-04
 * @version 1.0.0
 */
public class Test {

    public static void testFor(int[] arr) {
        final int length = arr.length;
        long start = System.nanoTime();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = arr[i];
        }
        long end = System.nanoTime();
        System.out.printf("for cost time: %s ms \n", (end - start) / 10_0000_0000.0);
    }

    public static void testCopy(int[] arr) {
        final int length = arr.length;
        long start = System.nanoTime();
        int[] res = new int[length];
        System.arraycopy(arr, 0, res, 0, length);
        long end = System.nanoTime();
        System.out.printf("copy array cost time: %s ms \n", (end - start) / 10_0000_0000.0);
    }

    public static void main(String[] args) {
        final int[] array = ArrayUtils.generateRandomArray(10_000_000, 0, Integer.MAX_VALUE);
        testFor(array);
        testCopy(array);
    }
}
