package com.algorithm.interview.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 二维矩阵顺时针遍历
 * <pre>
 *      1  2  3  4  5
 *      6  7  8  9  10
 *      11 12 13 14 15
 *      16 17 18 19 20
 * </pre>
 * <p>
 * 遍历二维矩阵结果：1，2，3，4，5，    10，15，20，   19，18， 17，16，  11，6，    7，8，9，    14，13，12
 * <p>
 * 思路：
 * 1、可以把二维数组的每一层拆解为 上下左右 4条变，按照顺时针遍历，对应的访问顺序是：上 -> 右 -> 下 -> 左，
 * 需要注意在每一层遍历的时候需要注意不能重复遍历
 *
 * @author QingFan 2020-09-21
 * @version 1.0.0
 */
public class RotateMatrixIterate {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        System.out.println(iterate(matrix));
        System.out.println(iterate(matrix2));
    }

    public static List<Integer> iterate(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        // 矩阵的行数

        int m = matrix.length;
        // 矩阵的列数
        int n = matrix[0].length;

        int count = (Math.min(m, n) + 1) / 2;

        for (int i = 0; i < count; i++) {
            // 从左到右遍历：上边
            for (int j = i; j < n - i; j++) {
                result.add(matrix[i][j]);
            }

            // 从上到下遍历：右边
            for (int j = i + 1; j < m - i; j++) {
                result.add(matrix[j][(n - 1) - i]);
            }

            // 从右到左遍历：下边
            for (int j = i + 1; j < n - i; j++) {
                result.add(matrix[(m - 1) - i][(n - 1) - j]);
            }

            // 从下到上遍历：左边
            for (int j = i + 1; j < m - 1 - i; j++) {
                result.add(matrix[(m - 1) - j][i]);

            }
        }
        return result;
    }
}
