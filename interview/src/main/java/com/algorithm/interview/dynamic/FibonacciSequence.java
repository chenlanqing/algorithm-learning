package com.algorithm.interview.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通过斐波那契数列来简单了解动态规划是怎么样的。<br/>
 * 动态规划的本质是：递归问题；递归问题 --> 重叠子问题
 *
 * @author BlueFish
 */
public class FibonacciSequence {

    public static void main(String[] args) {
        int n = 40;
        long start = System.nanoTime();
        int result = memorySearch(n, new HashMap<>());
        long end = System.nanoTime();
        System.out.println(String.format("Fibonacci %s result is %s, cost time is %s ns", n, result, (end - start)));

        start = System.nanoTime();
        result = dynamicProgramming(n);
        end = System.nanoTime();
        System.out.println(String.format("Fibonacci %s result is %s, cost time is %s ns", n, result, (end - start)));
    }

    /**
     * 基本算法：里面有很多重复运算，其最终的递归结果是一个递归树；<br/>
     * 比如计算 5：<br/>
     * 先计算 4、3；<br/>
     * 计算 4 的话需要计算3、2；计算 3 的话计算 2、1；<br/>
     * 计算 3 的话计算 2、1；。。。。<br/>
     * 如此重复计算：3 重复计算了两次，2 重复计算了三次，如果更大的输的话，重复计算的次数将会非常巨大。<br/>
     * 该算法的时间复杂度为指数级的 O(2^N)。
     *
     * @param n
     * @return
     */
    public static int bruteForce(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return bruteForce(n - 1) + bruteForce(n - 2);
    }

    /**
     * 记忆搜索（备忘录）：在基本算法的思路上将有计算过的数据存储起来，如果有重复计算的，就不递归调用；<br/>
     * 该算法的时间复杂度是：O(N)，空间复杂度是：O(N)-因为需要申请空间来存储计算过的数据
     *
     * @param n
     * @return
     */
    public static int memorySearch(int n, Map<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, memorySearch(n - 1, memo) + memorySearch(n - 2, memo));
        }
        return memo.get(n);
    }

    /**
     * 动态规划法：其实跟记忆搜索类似，记忆搜索是自顶向下解决问题；而动态规划是自下而上解决问题；<br/>
     * 相比于 记忆搜索法，这里动态规划并未使用递归，减少了函数的调用栈空间；同时减少了数据的搜索过程；<br/>
     * 该算法的时间复杂度是：O(N)，空间复杂度是：O(N)-因为需要申请空间来存储计算过的数据
     *
     * @param n
     * @return
     */
    public static int dynamicProgramming(int n) {
        List<Integer> list = new ArrayList<>(n);
        list.add(0);
        list.add(1);

        for (int i = 2; i <= n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list.get(n);
    }

}
