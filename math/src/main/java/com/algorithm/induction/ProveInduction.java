package com.algorithm.induction;

/**
 * 使用代码证明数学归纳法
 *
 * @author QingFan
 * @version 1.0.0
 * @date 2023年03月07日 20:09
 */
public class ProveInduction {

    public static boolean prove(int k, Result result) {
        // 证明n = 1时，命题是否成立
        if (k == 1) {
            if ((Math.pow(2, 1) - 1) == 1) {
                result.wheatNum = 1;
                result.wheatTotalNum = 1;
                return true;
            } else {
                return false;
            }
        } else {
            // 如果n = (k-1)时命题成立，证明n = k时命题是否成立
            boolean proveOrPreviousOne = prove(k - 1, result);
            result.wheatNum *= 2;
            result.wheatTotalNum += result.wheatNum;
            boolean proveOfCurrentOne = result.wheatTotalNum == (Math.pow(2, k) - 1);
            return proveOrPreviousOne && proveOfCurrentOne;
        }
    }

    public static class Result {
        public long wheatNum = 0; // 当前格的麦粒数
        public long wheatTotalNum = 0; // 目前为止麦粒的总数
    }
}
