package com.algorithm.leetcode.number.part300.part221_240;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2021年11月11日 18:01
 */
public class _240_Search2DMatrixII {

    /**
     * 在一个有序的二维数组中搜索一个值 该矩阵特性：
     * <li>每行的元素从左到右升序排列。</li>
     * <li>每列的元素从上到下升序排列。</li>
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
