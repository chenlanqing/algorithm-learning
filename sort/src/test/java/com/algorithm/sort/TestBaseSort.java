package com.algorithm.sort;

import com.algorithm.sort.base.bubble.BubbleSortInt;
import com.algorithm.sort.base.bubble.BubbleSortIntOpt1;
import com.algorithm.sort.base.bubble.BubbleSortIntOpt2;
import com.algorithm.sort.base.shell.ShellSortInt;
import com.algorithm.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;


public class TestBaseSort {

    @Test
    public void compareSort(){
//        int n = 100000;
//        int[] select = ArrayUtils.generateRandomArray(n, 1, 1000000);
//        int[] insert = ArrayUtils.copy(select, n);
//        int[] bubble = ArrayUtils.copy(select, n);
//        int[] shell = ArrayUtils.copy(select, n);
//
//        ArrayUtils.testSort("选择排序:", new SelectSortInt(), select, n);
//        ArrayUtils.testSort("插入排序:", new InsertSelectIntOpt(), insert, n);
//        ArrayUtils.testSort("冒泡排序:", new BubbleSortIntOpt2(), bubble, n);
//        ArrayUtils.testSort("希尔排序:", new ShellSortInt(), shell, n);
    }

    @Test
    public void testShellSort() {
        int n = 10;
        int[] arr = ArrayUtils.generateRandomArray(n, 1, 20);
        ArrayUtils.print(arr, n);
        ArrayUtils.testSort("希尔排序:", new ShellSortInt(), arr, n);
        ArrayUtils.print(arr, n);
    }

    @Test
    public void testBubble() {
        int n = 100000;
        int[] arr = ArrayUtils.generateNearySortArray(n, 5);
        int[] opt1 = Arrays.copyOf(arr, n);
        int[] opt2 = Arrays.copyOf(arr, n);
        ArrayUtils.testSort("冒泡排序未优化:", new BubbleSortInt(), arr, n);
        ArrayUtils.testSort("冒泡排序优化方案1:", new BubbleSortIntOpt1(), opt1, n);
        ArrayUtils.testSort("冒泡排序优化方案2:", new BubbleSortIntOpt2(), opt2, n);
    }

}