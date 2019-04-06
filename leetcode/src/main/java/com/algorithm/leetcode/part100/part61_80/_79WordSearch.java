package com.algorithm.leetcode.part100.part61_80;

/**
 * @author bluefish 2019-04-06
 * @version 1.0.0
 */
public class _79WordSearch {

    public static void main(String[] args) {
        _79WordSearch s = new _79WordSearch();

        char[][] board = new char[3][4];
        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'C';
        board[0][3] = 'E';
        board[1][0] = 'S';
        board[1][1] = 'F';
        board[1][2] = 'C';
        board[1][3] = 'S';
        board[2][0] = 'A';
        board[2][1] = 'D';
        board[2][2] = 'E';
        board[2][3] = 'E';
        /**
         * A B C E
         * S F C S
         * A D E E
         */
        System.out.println(s.exist(board, "ABCCED"));
        System.out.println(s.exist(board, "SEE"));
        System.out.println(s.exist(board, "ABCB"));
    }

    /**
     * 二位数组的长度
     */
    private int m, n;
    /**
     * 技巧点：向四个方向的偏移量，在二维平面上经常使用一个偏移量数组
     */
    private int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    /**
     * 已经访问过的字母
     */
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        assert m > 0;
        n = board[0].length;

        // 初始访问字母都为false
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            // 字母占位true
            visited[startX][startY] = true;
            // 向四个方向搜索
            for (int i = 0; i < 4; i++) {
                int newX = startX + offset[i][0];
                int newY = startY + offset[i][1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (searchWord(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            // 未匹配到，置为false；
            visited[startX][startY] = false;
        }

        return false;
    }
}
