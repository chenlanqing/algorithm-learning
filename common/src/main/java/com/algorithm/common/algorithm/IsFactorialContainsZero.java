package com.algorithm.common.algorithm;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量
 * <p>
 * https://mp.weixin.qq.com/s/8soc6zkzEis6LfIWH0-oeg
 *
 * @author bluefish 2019-05-06
 * @version 1.0.0
 */
public class IsFactorialContainsZero {

    /**
     * 1~9 这 9 个数字中只有 2（它的倍数） 与 5 （它的倍数）相乘才有 0 出现；所以，现在问题就变成了这个阶乘数中能配 多少对 2 与 5。
     * <p>
     * 一个数字进行拆分后 2 的个数肯定是大于 5 的个数的，所以能匹配多少对取决于 5 的个数；
     * <p>
     * 那么问题又变成了 统计阶乘数里有多少个 5 这个因子
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
