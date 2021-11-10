package com.algorithm.leetcode.number.part200.part181_200;

/**
 * floodFill算法
 *
 * @author bluefish 2019-04-06
 * @version 1.0.0
 */
public class _200NumberOfIslands {

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

    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m <= 0) {
            return 0;
        }
        n = grid[0].length;

        // 初始访问字母都为false
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    floodFill(grid, i, j);
                }
            }
        }
        return result;
    }

    boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private void floodFill(char[][] grid, int x, int y) {
        for (int i = 0; i < 4; i++) {
            visited[x][y] = true;
            int newx = x + offset[i][0];
            int newy = y + offset[i][1];

            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                floodFill(grid, newx, newy);
            }
        }
    }
}
