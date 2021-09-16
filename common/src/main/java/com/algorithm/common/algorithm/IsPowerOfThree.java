package com.algorithm.common.algorithm;

/**
 * 判断一个数是否是3的幂
 * <p>
 * 正常解法：使用循环不停的去除以3，看最后的迭代的商是否为1
 * <p>
 * 取巧的方法：使用数论的知识，3的幂次的质因子只有3
 * <p>
 *
 * @author bluefish 2019-04-29
 * @version 1.0.0
 */
public class IsPowerOfThree {

    /**
     * 要求是：输入的是int类型，正数范围是0~2^31，再次范围内最大的3次方数为：3^19 = 1162261467，那么只要看这个数能否被n整除即可
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(4));
        System.out.println(isPowerOfThree(19683));
        System.out.println(isPowerOfThree(19682));
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(54));
        System.out.println(isPowerOfThree(1162261467));
    }

}
