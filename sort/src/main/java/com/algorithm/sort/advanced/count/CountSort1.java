package com.algorithm.sort.advanced.count;

import java.util.Arrays;
import java.util.Random;

/**
 * 计数排序
 *
 * @author QingFan 2020-11-13
 * @version 1.0.0
 */
public class CountSort1 {

    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(countSort(array)));
    }

    public static int[] countSort(int[] array) {
        int max = array[0];
        int len = array.length;
        // 找出最大的元素，其作为计数数组的索引最大值
        for (int i = 1; i < len; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        // 遍历原数组，
        int[] countArr = new int[max + 1];
        for (int i = 0; i < len; i++) {
            countArr[array[i]]++;
        }
        // 迭代数组
        int[] result = new int[len];
        int index = 0;
        for (int i = 0; i < max + 1; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                result[index++] = i;
            }
        }
        return result;
    }
}
