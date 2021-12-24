package com.algorithm.sort.advanced.bucket.radix;

import com.algorithm.common.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 基数排序
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2021年12月10日 14:41
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort_2(arr);
        ArrayUtils.print(arr, arr.length);

        int[] A = {53, 3, 542, -5, 748, -100, -3, -10, 14, 214};
        radixSort_3(A);
        ArrayUtils.print(A, A.length);
    }

    /**
     * 实现1：基数排序
     */
    public static int[] radixSort(int[] A, int n) {
        // 定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        // 说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] buckets = new int[10][n];
        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：count[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] count = new int[10];
        int index = 0;
        for (int i = 1; i <= 1000; i *= 10) {
            // (针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < n; j++) {
                // 取出每个元素的对应位的值
                index = A[j] / i % 10;
                buckets[index][count[index]++] = A[j];
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            index = 0;
            // 遍历每一桶，并将桶中是数据，放入到原数组
            for (int j = 0; j < buckets.length; j++) {
                // 如果桶中，有数据，我们才放入到原数组
                for (int k = 0; k < count[j]; k++) {
                    //循环该桶即第j个桶(即第j个一维数组), 放入
                    A[index++] = buckets[j][k];
                    buckets[j][k] = 0;
                }
                // 第i+1轮处理后，需要将每个 count[j] = 0 ！！！！
                count[j] = 0;
            }
        }
        return A;
    }

    //基数排序方法
    public static void radixSort_2(int[] arr) {
        //根据前面的推导过程，我们可以得到最终的基数排序代码
        //1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        // 这里我们使用循环将代码处理
        /*
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶(即第k个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;

            }
            //System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }
        */

        // 第1轮(针对每个元素的个位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[j] / 1 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
        int index = 0;
        //遍历每一桶，并将桶中是数据，放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中，有数据，我们才放入到原数组
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶(即第k个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到arr
                    arr[index++] = bucket[k][l];
                }
            }
            //第l轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
            bucketElementCounts[k] = 0;

        }
        System.out.println("第1轮，对个位的排序处理 arr =" + Arrays.toString(arr));

        //==========================================

        //第2轮(针对每个元素的十位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的十位的值
            int digitOfElement = arr[j] / 10 % 10; //748 / 10 => 74 % 10 => 4
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
        index = 0;
        // 遍历每一桶，并将桶中是数据，放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中，有数据，我们才放入到原数组
            if (bucketElementCounts[k] != 0) {
                // 循环该桶即第k个桶(即第k个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr
                    arr[index++] = bucket[k][l];
                }
            }
            //第2轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
            bucketElementCounts[k] = 0;
        }
        System.out.println("第2轮，对个位的排序处理 arr =" + Arrays.toString(arr));

        //第3轮(针对每个元素的百位进行排序处理)
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的百位的值
            int digitOfElement = arr[j] / 100 % 10; // 748 / 100 => 7 % 10 = 7
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
        index = 0;
        // 遍历每一桶，并将桶中是数据，放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中，有数据，我们才放入到原数组
            if (bucketElementCounts[k] != 0) {
                // 循环该桶即第k个桶(即第k个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素放入到arr
                    arr[index++] = bucket[k][l];
                }
            }
            //第3轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
            bucketElementCounts[k] = 0;
        }
        System.out.println("第3轮，对个位的排序处理 arr =" + Arrays.toString(arr));

    }

    /**
     * 实现2：支持正负数的技术排序
     */
    public static void radixSort_3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 原数组：{53, 3, 542, -5, 748, -100, -3, -10, 14, 214};
        // 记录数组中负数的个数
        int negNum = 0;
        // 遍历数组，获取数组中负数的总个数
        for (int i = 0; i < arr.length; i++) {
            negNum += arr[i] < 0 ? 1 : 0;
        }
        // 负数的数组
        int[] negArr = new int[negNum];
        // 正数的数组
        int[] posArr = new int[arr.length - negNum];
        int negi = 0;
        int posi = 0;
        // 遍历原数组，填充正数组和负数组
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                // 负数数组存储正数，本来负数数组是：[-5,-100,-3, -10]，转变成正数数组：[5, 100, 3, 10]
                negArr[negi++] = -arr[i];
            } else {
                posArr[posi++] = arr[i];
            }
        }
        // 负数数组排序，正数数组：[5, 100, 3, 10]，排序之后是：[3, 5, 10, 100]
        radixSortForPositive(negArr);
        // 正数数组排序
        radixSortForPositive(posArr);
        int index = 0;
        // 将负数数组填充回原数组，由于是按正数排序的，所以遍历的时候从尾部开始遍历
        for (int i = negArr.length - 1; i >= 0; i--) {
            arr[index++] = -negArr[i];
        }
        for (int i = 0; i < posArr.length; i++) {
            arr[index++] = posArr[i];
        }
    }

    private static void radixSortForPositive(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        ArrayList<LinkedList<Integer>> qArr1 = new ArrayList<>();
        ArrayList<LinkedList<Integer>> qArr2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            qArr1.add(new LinkedList<Integer>());
            qArr2.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            qArr1.get(arr[i] % 10).offer(arr[i]);
        }
        long base = 10;
        while (base <= Integer.MAX_VALUE) {
            for (int i = 0; i < 10; i++) {
                LinkedList<Integer> queue = qArr1.get(i);
                while (!queue.isEmpty()) {
                    int value = queue.poll();
                    qArr2.get((int) (value / base) % 10).offer(value);
                }
            }
            ArrayList<LinkedList<Integer>> tmp = qArr1;
            qArr1 = qArr2;
            qArr2 = tmp;
            base *= 10;
        }
        int index = 0;
        for (int i = 0; i < 10; i++) {
            LinkedList<Integer> queue = qArr1.get(i);
            while (!queue.isEmpty()) {
                arr[index++] = queue.poll();
            }
        }
    }
}
