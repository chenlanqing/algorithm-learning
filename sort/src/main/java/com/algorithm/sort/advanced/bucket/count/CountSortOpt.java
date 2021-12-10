package com.algorithm.sort.advanced.bucket.count;

import com.algorithm.common.utils.ArrayUtils;

/**
 * 计数排序：优化稳定排序
 *
 * @author QingFan 2020-11-13
 * @version 1.0.0
 */
public class CountSortOpt {

    public static void main(String[] args) {
        int[] array = {95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        ArrayUtils.print(array, null, ",");
        ArrayUtils.print(countSort(array), null, ",");
    }

    public static int[] countSort(int[] array) {
        int max = array[0];
        int min = array[0];
        int len = array.length;
        // 找出最大和最小的元素，其作为计数数组的索引最大值
        for (int i = 1; i < len; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        int subLen = max - min;
        // 创建统计数组并统计对应元素个数
        int[] countArr = new int[subLen + 1];
        for (int i = 0; i < len; i++) {
            countArr[array[i] - min]++;
        }
        // 统计数组变形，后面的元素等于前面的元素之和
        int sum = 0;
        for (int i = 0; i < countArr.length; i++) {
            sum += countArr[i];
            countArr[i] = sum;
        }
        // 倒序遍历袁术数列，从统计数组找到正确的位置，输出到结果数组
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            result[countArr[array[i] - min] - 1] = array[i];
            countArr[array[i] - min]--;
        }
        return result;
    }
}
