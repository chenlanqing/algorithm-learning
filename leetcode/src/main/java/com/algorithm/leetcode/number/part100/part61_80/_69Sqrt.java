package com.algorithm.leetcode.number.part100.part61_80;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年12月27日 15:19
 */
public class _69Sqrt {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Math.sqrt(i) = " + Math.sqrt(i));
//            System.out.println("Self.sqrt(i) = " + sqrt(i, null));
//        }
        System.out.println("Math.sqrt(i) = " + Math.sqrt(10));
        System.out.println("Self.sqrt(i) = " + sqrt(10, null));
        System.out.println("Newton.sqrt(i) = " + sqrt(10, 1e-7));
    }

    /**
     * 小数位数
     *
     * @param t 需要求平方根的值
     * @param precise 小数位数，默认7位小数
     */
    public static double sqrt(int t, Double precise) {
        if (t < 0) {
            throw new IllegalArgumentException("Negative number cannot have a sqrt root");
        }
        // 先确定当前数所处的最小整数区间
        int i = 0;
        for (; i <= t; i++) {
            if (i * i == t) {
                return i;
            }
            if (i * i > t) {
                break;
            }
        }
        // 再通过二分法来进行判断检测
        double low = i - 1, high = i;
        precise = precise != null ? precise : 1e-7;
        double middle, squre;
        while (high - low > precise) {
            middle = (low + high) / 2;
            squre = middle * middle;
            if (squre > t) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return (low + high) / 2;
    }

    /**
     * 牛顿迭代法求平方根
     *
     * @param number 求值的数
     * @param accuracy 精度
     * @return Double
     */
    public static double sqrt(double number, double accuracy) {
        // 第一个猜测值
        double guess = number / 2;
        int count = 0;
        if (number < 0) {
            return Double.NaN;
        }
        // 当两个猜测的差值大于精度即return
        while (Math.abs(guess - (number / guess)) > accuracy) {
            //迭代公式推导而成
            guess = (guess + (number / guess)) / 2;
            count++;
//            System.out.printf("try count = %d, guess = %f\n", count, guess);
        }
//        System.out.printf("final result = %f\n", guess);
        return guess;
    }
}
