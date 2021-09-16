package com.algorithm.interview.array;

import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数组长度");
        int n = sc.nextInt();
        System.out.println("输入数组数据（用空格分开）");
        int i;
        int a[] = new int[n];
        for (i = 0; i < n; i++)
            a[i] = sc.nextInt();

        /**
         * 1：用maxValue记录当前连续子数组和为最大的和的值，初始化其值为：maxValue=a[0]。注：记数组为a[n]。
         *
         * 2：这个过程总的思想就是，从数组头开始往后，每次加进一个值，它们的和记为tempValue，若tempValue比新加进来的数值本身要小，
         * 应该从这个位置开始重新开始计算tempValue的值。而每次的tempValue都应该和maxValue作比较，若tempValue更大，
         * 则应更新maxValue的值为tempValue的值，相对的maxValue对应的子数组也要变成tempValue对应的子数组。
         * 这样下来，到最后将数组完全扫描一遍之后，就能得到最大和的连续子数组以及其和maxValue。这样的时间复杂度正好是O(n)。
         *
         * 3：执行for循环:for(i=1;i<n;i++)。循环体内容为：用tempValue记录当前tempValue同数组中下一个
         * 值的和即令：tempValue=tempValue+a[i]，初始化其值为：tempValue=a[0]。
         * 更新tempValue的值之后，若tempValue小于或等于a[i]，则应舍弃目前tempValue对应的子数组，使其重新对应一个新数组，
         * 应该使tempValue对应的子数组首尾都指向a[i]。而若tempValue大于a[i]且tempValue大于maxValue，则更新maxValue对应的子数组，
         * 令其对应的子数组变成tempValue对应的子数组。这些工作做完后，继续下一次循环
         */

        int begin = 0;//子数组开始下标
        int end = 0;//子数组结束下标
        int maxValue = a[0];
        int tempValue = maxValue;


        //for循环寻找最大和的连续子数组
        for (i = 1; i < n; i++) {
            tempValue += a[i];
            if ((tempValue > a[i]) && (tempValue > maxValue)) {
                end = i;
                maxValue = tempValue;
            } else if (tempValue <= a[i]) {
                begin = i;
                end = i;
                tempValue = a[i];

            }
        }


        //输出最大和的连续子数组的相关信息
        System.out.println("最大子数组和为：" + maxValue + "\n子数组内容为：");
        System.out.println("下标：");
        for (i = begin; i <= end; i++)
            System.out.print(i + "  ");
        System.out.println("\n" + "下标对应数值：");
        for (i = begin; i <= end; i++)
            System.out.print(a[i] + "  ");


    }

}