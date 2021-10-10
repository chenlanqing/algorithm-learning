package com.algorithm.interview.offer.day05;

/**
 * @author QingFan 2021/10/9
 * @version 1.0.0
 */
public class _04_FindDataInTwoArray {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。<br/> 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     *
     * <pre>
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * 给定 target = 20，返回 false。
     * </pre>
     * <pre>
     * 思路：
     * 仔细观察矩阵，可以发现：左下角元素 为所在列最大元素，所在行最小元素
     * 如果 左下角元素 大于了目标值，则目标值一定在该行的上方， 左下角元素 所在行可以消去。
     * 如果 左下角元素 小于了目标值，则目标值一定在该列的右方， 左下角元素 所在列可以消去。
     * 具体操作为从矩阵左下角元素开始遍历，并与目标值对比：
     *
     * 当 matrix[i][j] > target 时： 行索引向上移动一格（即 i--），即消去矩阵第 i 行元素；
     * 当 matrix[i][j] < target 时： 列索引向右移动一格（即 j++），即消去矩阵第 j 列元素；
     * 当 matrix[i][j] == target 时： 返回 true。
     * 如果越界，则返回 false。
     * </pre>
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
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

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            int col = matrix[i].length;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
