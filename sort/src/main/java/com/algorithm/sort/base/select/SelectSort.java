package com.algorithm.sort.base.select;

/**
 * 通用选择排序,这样可以是自定义的类型,有一点需要注意:自定义的类型需要实现了 Comparable 接口
 */
public class SelectSort{

    public <T extends Comparable<? super T>> void sort(T[] arr, int n) {
        if (arr == null || arr.length != n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private <T extends Comparable<? super T>> void swap(T[] arr, int i, int min) {
        T temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
