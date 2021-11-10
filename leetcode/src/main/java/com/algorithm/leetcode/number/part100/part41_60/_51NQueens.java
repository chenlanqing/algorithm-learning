package com.algorithm.leetcode.number.part100.part41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N-皇后问题：判断不合法情况
 * <li>竖向：col[i]表示第i列被占用</li>
 * <li>对角线1：dia1[i]表示第i条对角线1被占用，对角线1： 2*n - 1个, i+j</li>
 * <li>对角线2：dia1[i]表示第i条对角线2被占用，对角线2： 2*n - 1个，索引：i-j+n-1</li>
 *
 * @author bluefish 2019-04-06
 * @version 1.0.0
 */
public class _51NQueens {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = (new _51NQueens()).solveNQueens(n);
        for (List<String> board : res)
            printBoard(board);
    }


    private static void printBoard(List<String> board) {
        for (String s : board)
            System.out.println(s);
        System.out.println();
    }

    private ArrayList<List<String>> result = new ArrayList<List<String>>();

    private boolean col[], dia1[], dia2[];

    public List<List<String>> solveNQueens(int n) {
        result.clear();

        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<Integer>();

        putQueue(n, 0, row);

        return result;
    }

    private void putQueue(int n, int index, LinkedList<Integer> row) {
        if (index == n) {
            result.add(generateResult(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 尝试将第index行的皇后摆放在第i列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.addLast(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueue(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }
    }

    private List<String> generateResult(int n, LinkedList<Integer> row) {
        assert row.size() == n;

        ArrayList<String> list = new ArrayList<String>(n);
        for (int i = 0; i < n; i++) {
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            list.add(new String(charArray));
        }

        return list;
    }
}
